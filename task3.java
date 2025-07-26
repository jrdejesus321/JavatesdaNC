public class task3 {
    public static void main(String[] args) {
        String a = new String("Wow");
        String c = "";
        String b = a;
        String d = b + "!";

        boolean b1 = a == b;
        boolean b2 = d.equals(b + "!");
        boolean b3 = !c.equals(a);

        if (b1 && b2 && b3) {
            System.out.println("Success!");
        }

    }
}

