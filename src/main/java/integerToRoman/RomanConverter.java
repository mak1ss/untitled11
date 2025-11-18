package integerToRoman;

public class RomanConverter {

    private static final int[] values = {
        1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    };
    
    private static final String[] symbols = {
        "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };

    /**
     * Конвертує ціле число в римський числівник.
     * @param number Число від 1 до 3999.
     * @return Рядок з римським числівником.
     */
    public String toRoman(int number) {
        if (number <= 0 || number > 3999) {
            throw new IllegalArgumentException("Number must be between 1 and 3999.");
        }

        StringBuilder romanResult = new StringBuilder();

        // Проходимо по кожному символу/значенню
        for (int i = 0; i < values.length; i++) {
            // "Жадібно" віднімаємо це значення, доки можемо
            while (number >= values[i]) {
                romanResult.append(symbols[i]);
                number -= values[i];
            }
        }

        return romanResult.toString();
    }
}