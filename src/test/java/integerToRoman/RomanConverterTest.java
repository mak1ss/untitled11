package integerToRoman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RomanConverterTest {

    private RomanConverter converter;

    @BeforeEach
    void setUp() {
        // Створюємо новий екземпляр конвертера перед кожним тестом
        converter = new RomanConverter();
    }

    @DisplayName("Test Basic and Complex Valid Conversions (25 cases)")
    @ParameterizedTest(name = "{0} should be converted to {1}")
    @CsvSource({
            // Базові одиниці (1-9)
            "1, I",
            "2, II",
            "3, III",
            "4, IV",
            "5, V",
            "6, VI",
            "8, VIII",
            "9, IX",
            
            // Десятки (10-99)
            "10, X",
            "12, XII",     // (з прикладу в завданні)
            "27, XXVII",    // (з прикладу в завданні)
            "39, XXXIX",
            "40, XL",
            "49, XLIX",
            "50, L",
            "88, LXXXVIII",
            "90, XC",
            "99, XCIX",

            // Сотні (100-999)
            "100, C",
            "400, CD",
            "444, CDXLIV",
            "500, D",
            "888, DCCCLXXXVIII",
            "900, CM",

            // Тисячі та максимальне значення
            "1000, M",
            "1994, MCMXCIV", // Класичний складний випадок
            "2024, MMXXIV",  // Сучасний рік
            "3999, MMMCMXCIX" // Максимальне значення
    })
    void testValidNumberConversions(int input, String expected) {
        assertEquals(expected, converter.toRoman(input));
    }

    // --- Окремі тести для невалідних вхідних даних ---

    @Test
    @DisplayName("Test Zero should throw IllegalArgumentException")
    void testZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.toRoman(0);
        }, "Number must be between 1 and 3999.");
    }

    @Test
    @DisplayName("Test Negative number should throw IllegalArgumentException")
    void testNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.toRoman(-10);
        }, "Number must be between 1 and 3999.");
    }

    @Test
    @DisplayName("Test Number larger than 3999 should throw IllegalArgumentException")
    void testNumberTooLarge() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.toRoman(4000);
        }, "Number must be between 1 and 3999.");
    }
}