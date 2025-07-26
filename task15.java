public class task15 {

    interface Shape {
        double calculateArea();
        double calculatePerimeter();
    }

    static abstract class AbstractShape implements Shape {
        String color;
        double length;
        double width;

        public AbstractShape(String color, double length, double width) {
            this.color = color;
            this.length = length;
            this.width = width;
        }

        public double calculateArea() {
            return length * width;
        }

        public double calculatePerimeter() {
            return 2 * (length + width);
        }
    }

    static class Circle extends AbstractShape {
        double radius;

        public Circle(String color, double radius) {
            super(color, 0, 0);
            this.radius = radius;
        }

        public double calculateArea() {
            return Math.PI * radius * radius;
        }

        public double calculatePerimeter() {
            return 2 * Math.PI * radius;
        }
    }

    static class Rectangle extends AbstractShape {
        public Rectangle(String color, double length, double width) {
            super(color, length, width);
        }

        public double calculateArea() {
            return length * width;
        }

        public double calculatePerimeter() {
            return 2 * (length + width);
        }
    }

    public static void main(String[] args) {
        AbstractShape[] shapes = new AbstractShape[2];
        shapes[0] = new Circle("Red", 5);
        shapes[1] = new Rectangle("Blue", 4, 6);

        for (int i = 0; i < shapes.length; i++) {
            System.out.println("Shape " + (i + 1) + ":");
            System.out.println("Color: " + shapes[i].color);
            System.out.println("Area: " + shapes[i].calculateArea());
            System.out.println("Perimeter: " + shapes[i].calculatePerimeter());
            System.out.println();
        }
    }
}
