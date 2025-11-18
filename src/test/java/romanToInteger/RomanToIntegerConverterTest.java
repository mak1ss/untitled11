package romanToInteger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RomanToIntegerConverterTest {

    private RomanToIntegerConverter converter;

    @BeforeEach
    void setUp() {
        converter = new RomanToIntegerConverter();
    }

    @DisplayName("Test Valid Roman Numerals")
    @ParameterizedTest(name = "{0} should be converted to {1}")
    @CsvSource({
            // 10+ тестових випадків
            "I, 1",          // 1. Проста цифра
            "III, 3",        // 2. Просте додавання
            "IV, 4",         // 3. Просте віднімання
            "V, 5",          // 4. Проста цифра
            "IX, 9",         // 5. Віднімання (I)
            "XL, 40",        // 6. Віднімання (X)
            "XC, 90",        // 7. Віднімання (C)
            "CD, 400",       // 8. Віднімання (D)
            "CM, 900",       // 9. Віднімання (M)
            "MCMXCIV, 1994", // 10. Складний випадок (з вашого опису)
            "MMMCMXCIX, 3999",// 11. Максимальне значення
            "mcmlxviii, 1968" // 12. Тест на нечутливість до регістру (lowercase)
    })
    void testValidRomanNumerals(String roman, int expected) {
        assertEquals(expected, converter.toInt(roman));
    }

    // --- Tests for Exceptions Handling ---

    @Test
    @DisplayName("Test Null input should throw IllegalArgumentException")
    void testNullInput() {
        // Перевіряємо, що виклик toInt(null) кидає виняток
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            converter.toInt(null);
        });
        
        // (Опціонально) Перевіряємо текст повідомлення про помилку
        assertEquals("Input string cannot be null or empty.", exception.getMessage());
    }

    @Test
    @DisplayName("Test Empty string input should throw IllegalArgumentException")
    void testEmptyInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.toInt("");
        });
    }

    @Test
    @DisplayName("Test Blank string input should throw IllegalArgumentException")
    void testBlankInput() {
        // Тестуємо рядок, що містить лише пробіли
        assertThrows(IllegalArgumentException.class, () -> {
            converter.toInt("   ");
        });
    }

    @Test
    @DisplayName("Test Invalid character (e.g., 'Z') should throw IllegalArgumentException")
    void testInvalidCharacter() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            converter.toInt("MCMZXCIV");
        });

        assertTrue(exception.getMessage().contains("Invalid character in Roman numeral: Z"));
    }

    @Test
    @DisplayName("Test Invalid character (e.g., '5') should throw IllegalArgumentException")
    void testInvalidNumberCharacter() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.toInt("V5");
        });
    }
}