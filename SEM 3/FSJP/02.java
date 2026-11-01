// To calculate the area of different shapes (circle, rectangle, triangle) using Method Overloading.

class ShapeArea {
    // 1. Area of Circle: pi * r^2
    double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    // 2. Area of Rectangle: length * breadth
    double calculateArea(double length, double breadth) {
        return length * breadth;
    }

    // 3. Area of Triangle: 1/2 * base * height
    double calculateArea(float base, float height) {
        return 0.5 * base * height;
    }

    // Overloaded variant for triangle with 3 sides using Heron's formula
    double calculateArea(double a, double b, double c) {
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}

class MethodOverloadingDemo {
    public static void main(String[] args) {
        ShapeArea calculator = new ShapeArea();

        System.out.println("--- Construction Design Shape Area Calculator ---\n");

        // Circle
        double radius = 7.0;
        double circleArea = calculator.calculateArea(radius);
        System.out.printf("Area of Circle (radius = %.2f)            : %.2f%n", radius, circleArea);

        // Rectangle
        double length = 12.0;
        double breadth = 8.0;
        double rectArea = calculator.calculateArea(length, breadth);
        System.out.printf("Area of Rectangle (length = %.2f, breadth = %.2f): %.2f%n", length, breadth, rectArea);

        // Triangle with base and height
        float base = 10.0f;
        float height = 6.0f;
        double triArea = calculator.calculateArea(base, height);
        System.out.printf("Area of Triangle (base = %.2f, height = %.2f)  : %.2f%n", base, height, triArea);

        // Triangle with three sides
        double a = 3.0, b = 4.0, c = 5.0;
        double triHeronArea = calculator.calculateArea(a, b, c);
        System.out.printf("Area of Triangle (sides = %.1f, %.1f, %.1f)       : %.2f%n", a, b, c, triHeronArea);
    }
}
