public class TwoSum {

        public static void main(String[] args) {
                // Sample test cases
                        findTwoSum(9, 2, 7, 11, 15);       // Output: [0,1]
                                findTwoSum(6, 3, 2, 4);            // Output: [1,2]
                                        findTwoSum(20, 2, 3, 6, 6);        // Output: target not found
                                            }

                                                // Method that accepts target and varargs input
                                                    public static void findTwoSum(int target, int... numbers) {
                                                            // Check each pair of numbers
                                                                    for (int i = 0; i < numbers.length; i++) {
                                                                                for (int j = i + 1; j < numbers.length; j++) {
                                                                                                if (numbers[i] + numbers[j] == target) {
                                                                                                                    System.out.println("[" + i + "," + j + "]");
                                                                                                                                        return; // Found the pair, exit the method
                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                            }
                                                                                                                                                                                    // If no pair found
                                                                                                                                                                                            System.out.println("target not found");
                                                                                                                                                                                                }
                                                                                                                                                                                                }
}