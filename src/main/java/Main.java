public class Main {
    public static void main(String[] args) {
        BmiCalculator calculator = new BmiCalculator(80, 1.52);
        System.out.println(calculator.getResult());
    }
}

class BmiCalculator {

    private double weight;
    private double height;

    private static final double UNDERWEIGHT_THRESHOLD = 18.5;
    private static final double NORMAL_THRESHOLD = 25.0;
    private static final double OVERWEIGHT_THRESHOLD = 30.0;

    public BmiCalculator(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBmi() {
        if (height <= 0) {
            return 0;
        }
        return weight / (height * height);
    }

    public String getResult() {
        double bmi = getBmi();

        if (bmi <= 0) {
            return "Invalid data";
        }

        if (bmi < UNDERWEIGHT_THRESHOLD) {
            return "Deficit";
        } else if (bmi < NORMAL_THRESHOLD) {
            return "Norm";
        } else if (bmi < OVERWEIGHT_THRESHOLD) {
            return "Warning!";
        } else {
            return "Fat";
        }
    }
}