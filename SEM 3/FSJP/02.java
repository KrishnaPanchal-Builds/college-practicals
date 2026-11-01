class ShapeArea {
    double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    double calculateArea(double length, double breadth) {
        return length * breadth;
    }

    double calculateArea(float base, float height) {
        return 0.5 * base * height;
    }

    double calculateArea(double a, double b, double c) {
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}

class MethodOverloadingDemo {
    public static void main(String[] args) {
        ShapeArea calculator = new ShapeArea();

        System.out.println("--- Construction Design Shape Area Calculator ---\n");

        double radius = 7.0;
        double circleArea = calculator.calculateArea(radius);
        System.out.printf("Area of Circle (radius = %.2f)            : %.2f%n", radius, circleArea);

        double length = 12.0;
        double breadth = 8.0;
        double rectArea = calculator.calculateArea(length, breadth);
        System.out.printf("Area of Rectangle (length = %.2f, breadth = %.2f): %.2f%n", length, breadth, rectArea);

        float base = 10.0f;
        float height = 6.0f;
        double triArea = calculator.calculateArea(base, height);
        System.out.printf("Area of Triangle (base = %.2f, height = %.2f)  : %.2f%n", base, height, triArea);

        double a = 3.0, b = 4.0, c = 5.0;
        double triHeronArea = calculator.calculateArea(a, b, c);
        System.out.printf("Area of Triangle (sides = %.1f, %.1f, %.1f)       : %.2f%n", a, b, c, triHeronArea);
    }
}
