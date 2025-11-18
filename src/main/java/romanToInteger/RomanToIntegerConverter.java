package romanToInteger;

import java.util.Map;

public class RomanToIntegerConverter {

    // Словник для швидкого доступу до значень символів
    private static final Map<Character, Integer> romanValues = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    /**
     * Конвертує рядок з римським числівником у ціле число.
     * @param roman Рядок з римським числівником (наприклад, "MCMXCIV").
     * @return Ціле число.
     * @throws IllegalArgumentException якщо рядок null, порожній або містить недійсні символи.
     */
    public int toInt(String roman) {
        if (roman == null || roman.trim().isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty.");
        }

        // Робимо конвертер нечутливим до регістру
        String upperRoman = roman.toUpperCase();

        int total = 0;
        int prevValue = 0;

        // Ітеруємо справа наліво
        for (int i = upperRoman.length() - 1; i >= 0; i--) {
            char currentChar = upperRoman.charAt(i);
            
            // Перевірка на недійсний символ
            if (!romanValues.containsKey(currentChar)) {
                throw new IllegalArgumentException("Invalid character in Roman numeral: " + currentChar);
            }

            int currentValue = romanValues.get(currentChar);

            // Головна логіка: віднімаємо чи додаємо?
            if (currentValue < prevValue) {
                total -= currentValue; // Наприклад, 'I' перед 'V' (IV)
            } else {
                total += currentValue; // Наприклад, 'V' перед 'I' (VI)
            }
            
            prevValue = currentValue;
        }

        return total;
    }
}