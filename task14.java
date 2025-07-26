public class task14 {

    static abstract class abstractClass {
        abstract void abstractMethod();

        void concreteMethod() {
            String[] message = {"This", "is", "a", "concrete", "method."};
            for (int i = 0; i < message.length; i++) {
                System.out.print(message[i] + " ");
            }
            System.out.println();
        }
    }

    static class B extends abstractClass {
        void abstractMethod() {
            String[] msg = {"This", "is", "B's", "implementation", "of", "abstractMethod."};
            for (int i = 0; i < msg.length; i++) {
                System.out.print(msg[i] + " ");
            }
            System.out.println();
        }
    }

    static class C extends abstractClass {
        void abstractMethod() {
            String[] msg = {"This", "is", "C's", "implementation", "of", "abstractMethod."};
            for (int i = 0; i < msg.length; i++) {
                System.out.print(msg[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        B b = new B();
        b.abstractMethod();
        b.concreteMethod();

        C c = new C();
        c.abstractMethod();
        c.concreteMethod();
    }
}
