// To manage mobile store product records using Constructor Overloading.

class Product {
    private String name;
    private double price;
    private boolean priceAvailable;

    // Constructor 1: Registered with only name
    public Product(String name) {
        this.name = name;
        this.price = 0.0;
        this.priceAvailable = false;
    }

    // Constructor 2: Registered with name and price
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.priceAvailable = true;
    }

    // Display product record
    public void displayProduct() {
        System.out.println("Product Name : " + name);
        if (priceAvailable) {
            System.out.printf("Price        : Rs. %.2f%n", price);
        } else {
            System.out.println("Price        : Price Not Specified / Upcoming");
        }
        System.out.println("----------------------------------------");
    }
}

class ConstructorOverloadingDemo {
    public static void main(String[] args) {
        System.out.println("--- Mobile Store Product Inventory ---\n");

        // Product registered with only name
        System.out.println("Product 1 (Registered with name only):");
        Product p1 = new Product("Samsung Galaxy S24 Ultra");
        p1.displayProduct();

        // Product registered with name and price
        System.out.println("Product 2 (Registered with name and price):");
        Product p2 = new Product("Apple iPhone 16 Pro", 119900.00);
        p2.displayProduct();

        // Product registered with name only (upcoming model)
        System.out.println("Product 3 (Registered with name only):");
        Product p3 = new Product("Google Pixel 10 Pro");
        p3.displayProduct();
    }
}
