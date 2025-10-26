// IsoscelesTrapezoidTest.java

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IsoscelesTrapezoidTest {

    private IsoscelesTrapezoid trapezoid;
    private static final double DELTA = 1e-9; // Допуск для порівняння double

    @BeforeEach
    void setUp() {
        // Створюємо трапецію: основи 10 і 2, бічна сторона 5.
        // Це дає висоту 3 і проєкцію 4 (трикутник 3-4-5).
        trapezoid = new IsoscelesTrapezoid(10, 2, 5);
    }

    @Test
    @DisplayName("Тест 1: Обчислення периметру")
    void testGetPerimeter() {
        double expected = 10 + 2 + 5 + 5; // 22.0
        assertEquals(expected, trapezoid.getPerimeter(), DELTA);
    }

    @Test
    @DisplayName("Тест 2: Обчислення висоти")
    void testGetHeight() {
        double expected = 3.0; // Базується на трикутнику 3-4-5
        assertEquals(expected, trapezoid.getHeight(), DELTA);
    }

    @Test
    @DisplayName("Тест 3: Обчислення середньої лінії")
    void testGetMiddleLine() {
        double expected = (10 + 2) / 2.0; // 6.0
        assertEquals(expected, trapezoid.getMiddleLine(), DELTA);
    }

    @Test
    @DisplayName("Тест 4: Обчислення площі")
    void testGetArea() {
        // Area = middleLine * height = 6.0 * 3.0
        double expected = 18.0;
        assertEquals(expected, trapezoid.getArea(), DELTA);
    }

    @Test
    @DisplayName("Тест 5: Обчислення діагоналі")
    void testGetDiagonal() {
        // d^2 = (baseA * baseB) + (leg * leg) = (10 * 2) + (5 * 5) = 20 + 25 = 45
        double expected = Math.sqrt(45.0); // 6.7082039...
        assertEquals(expected, trapezoid.getDiagonal(), DELTA);
    }

    // --- Додатковий тест на валідацію ---

    @Test
    @DisplayName("Тест: Конструктор кидає виняток при неможливій геометрії")
    void testConstructorValidation() {
        // Проєкція (10-2)/2 = 4. Бічна сторона 3 < 4, що неможливо.
        assertThrows(IllegalArgumentException.class, () -> {
            new IsoscelesTrapezoid(10, 2, 3);
        });

        // Від'ємна сторона
        assertThrows(IllegalArgumentException.class, () -> {
            new IsoscelesTrapezoid(10, -2, 5);
        });
    }
}