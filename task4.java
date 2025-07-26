import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        System.out.println("---PALINDROME---");
        System.out.print("Enter a word:");
        Scanner scan = new Scanner(System.in);
        String palindrome = scan.nextLine();
        StringBuilder sb = new StringBuilder(palindrome);
        sb.reverse().toString();
        System.out.println(sb);

        if (palindrome.equalsIgnoreCase(sb.toString())){
            System.out.println("The input string is a palindrome.");
        } else {
            System.out.println("The input string is not a palindrome");
        }
    }
}
