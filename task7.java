import java.util.Scanner;

public class task7 {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
                    System.out.print("Enter First number:");
                            int num1 = scanner.nextInt();
                                    System.out.print("Enter Second number:");
                                            int num2 = scanner.nextInt();
                                                    System.out.println("Addition: "+sum(num1,num2));
                                                            System.out.println("Subtraction: "+diff(num1,num2));
                                                                    System.out.println("Multiplication: "+product(num1,num2));
                                                                            System.out.println("Division: "+quotient(num1,num2));
                                                                                }

                                                                                    static int sum(int a, int b){
                                                                                            int result = a + b;
                                                                                                    return result;
                                                                                                        }

                                                                                                            static int diff(int a, int b){
                                                                                                                    int result = a - b;
                                                                                                                            return result;
                                                                                                                                }

                                                                                                                                    static int product(int a, int b){
                                                                                                                                            int result = a * b;
                                                                                                                                                    return result;
                                                                                                                                                        }

                                                                                                                                                            static float quotient(float a, float b){
                                                                                                                                                                    float result = a / b;
                                                                                                                                                                            return result;
                                                                                                                                                                                }

                                                                                                                                                                                }

                                                                                                                                                                                