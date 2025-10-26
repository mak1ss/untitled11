/**
 * Клас, що представляє рівнобічну трапецію.
 * Трапеція визначається трьома параметрами:
 * - baseA: Довжина першої (зазвичай більшої) основи.
 * - baseB: Довжина другої (зазвичай меншої) основи.
 * - leg: Довжина бічної сторони (обидві бічні сторони рівні).
 */
public class IsoscelesTrapezoid {

    private double baseA;
    private double baseB;
    private double leg;

    /**
     * Конструктор для створення рівнобічної трапеції.
     *
     * @param baseA Довжина першої основи.
     * @param baseB Довжина другої основи.
     * @param leg Довжина бічної сторони.
     * @throws IllegalArgumentException якщо сторони мають некоректні значення
     * (від'ємні, нульові, або неможливі для геометрії трапеції).
     */
    public IsoscelesTrapezoid(double baseA, double baseB, double leg) {
        if (baseA <= 0 || baseB <= 0 || leg <= 0) {
            throw new IllegalArgumentException("Довжини сторін повинні бути додатніми.");
        }

        // Перевірка геометричної можливості: бічна сторона не може бути 
        // коротшою за половину різниці основ (це проєкція бічної сторони).
        double projection = Math.abs(baseA - baseB) / 2.0;

        // Якщо projection = 0 (прямокутник), leg > 0, що вже перевірено.
        // Якщо projection > 0, leg має бути строго більшим, інакше висота = 0.
        if (projection > 0 && leg <= projection) {
            throw new IllegalArgumentException("Бічна сторона (leg) занадто коротка для заданих основ.");
        }

        this.baseA = baseA;
        this.baseB = baseB;
        this.leg = leg;
    }

    /**
     * Метод 1: Обчислює периметр трапеції.
     * Периметр = сума всіх сторін.
     *
     * @return Периметр трапеції.
     */
    public double getPerimeter() {
        return baseA + baseB + 2 * leg;
    }

    /**
     * Метод 2: Обчислює висоту трапеції.
     * Висота (h) знаходиться за теоремою Піфагора з прямокутного трикутника,
     * утвореного бічною стороною (гіпотенуза), висотою (катет) та
     * проєкцією бічної сторони на основу (другий катет).
     *
     * @return Висота трапеції.
     */
    public double getHeight() {
        // x = (a - b) / 2 (проєкція бічної сторони на більшу основу)
        double projection = Math.abs(baseA - baseB) / 2.0;
        // h^2 = leg^2 - x^2
        return Math.sqrt(leg * leg - projection * projection);
    }

    /**
     * Метод 3: Обчислює середню лінію трапеції.
     * Середня лінія = (основаA + основаB) / 2.
     *
     * @return Довжина середньої лінії.
     */
    public double getMiddleLine() {
        return (baseA + baseB) / 2.0;
    }

    /**
     * Метод 4: Обчислює площу трапеції.
     * Площа = середня лінія * висота.
     *
     * @return Площа трапеції.
     */
    public double getArea() {
        // Area = ((a + b) / 2) * h
        return getMiddleLine() * getHeight();
    }

    /**
     * Метод 5: Обчислює довжину діагоналі рівнобічної трапеції.
     * Використовує теорему Птолемея для вписаного чотирикутника (рівнобічна 
     * трапеція завжди є вписаною): d^2 = a*b + c^2,
     * де a і b - основи, c - бічна сторона.
     *
     * @return Довжина діагоналі.
     */
    public double getDiagonal() {
        // d^2 = (baseA * baseB) + (leg * leg)
        return Math.sqrt(baseA * baseB + leg * leg);
    }

    public double getBaseA() {
        return baseA;
    }

    public double getBaseB() {
        return baseB;
    }

    public double getLeg() {
        return leg;
    }
}