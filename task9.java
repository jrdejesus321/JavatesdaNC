public class task9 {

    public static int add(int a, int b) {
        int result = a;
        for (int i = 0; i < b; i++) {
            result++;
        }
        return result;
    }

    public static int subtract(int a, int b) {
        int result = a;
        for (int i = 0; i < b; i++) {
            result--;
        }
        return result;
    }

    public static int multiply(int a, int b) {
        int result = 0;
        for (int i = 0; i < b; i++) {
            result = add(result, a);
        }
        return result;
    }

    public static float divide(int a, int b) {
        if (b == 0) {
            System.out.println("Division: Cannot divide by zero!");
            return 0;
        }

        int count = 0;
        int remainder = a;

        while (remainder >= b) {
            remainder = subtract(remainder, b);
            count++;
        }

        return (float) count;
    }

    public static void main(String[] args) {
        System.out.println("--- Demonstrating Basic Math Operations ---");

        int[] numbers1 = {10, 25, 100};
        int[] numbers2 = {5, 4, 10};

        for (int i = 0; i < 3; i++) {
            int num1 = numbers1[i];
            int num2 = numbers2[i];

            System.out.println("\n--- Operations with " + num1 + " and " + num2 + " ---");

            int sum = add(num1, num2);
            System.out.println("Addition: " + num1 + " + " + num2 + " = " + sum);

            int diff = subtract(num1, num2);
            System.out.println("Subtraction: " + num1 + " - " + num2 + " = " + diff);

            int prod = multiply(num1, num2);
            System.out.println("Multiplication: " + num1 + " * " + num2 + " = " + prod);

            float quot = divide(num1, num2);
            System.out.println("Division (approximate): " + num1 + " / " + num2 + " = " + quot);
        }

        System.out.println("\n--- End of Demonstration ---");
    }
}
