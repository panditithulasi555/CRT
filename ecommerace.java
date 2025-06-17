import java.util.ArrayList;
import java.util.Scanner;

// Product class
class Product {
    int id;
    String name;
    double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return id + ". " + name + " - $" + price;
    }
}

// ShoppingCart class
class ShoppingCart {
    ArrayList<Product> cartItems = new ArrayList<>();

    public void addProduct(Product product) {
        cartItems.add(product);
        System.out.println(product.name + " added to cart.");
    }

    public void viewCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        System.out.println("Items in your cart:");
        for (Product p : cartItems) {
            System.out.println(p);
        }
    }

    public double checkout() {
        double total = 0;
        for (Product p : cartItems) {
            total += p.price;
        }
        cartItems.clear();  // empty cart after checkout
        return total;
    }
}

// Main class with e-commerce logic
public class EcommerceApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample product list
        Product[] products = {
            new Product(1, "Laptop", 999.99),
            new Product(2, "Smartphone", 499.99),
            new Product(3, "Headphones", 149.99),
            new Product(4, "Keyboard", 89.99)
        };

        ShoppingCart cart = new ShoppingCart();
        boolean running = true;

        System.out.println("Welcome to the E-commerce App!");

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Available Products:");
                    for (Product p : products) {
                        System.out.println(p);
                    }
                    break;
                case 2:
                    System.out.print("Enter product ID to add to cart: ");
                    int productId = scanner.nextInt();
                    Product selectedProduct = null;
                    for (Product p : products) {
                        if (p.id == productId) {
                            selectedProduct = p;
                            break;
                        }
                    }
                    if (selectedProduct != null) {
                        cart.addProduct(selectedProduct);
                    } else {
                        System.out.println("Invalid product ID.");
                    }
                    break;
                case 3:
                    cart.viewCart();
                    break;
                case 4:
                    double total = cart.checkout();
                    if (total > 0) {
                        System.out.printf("Your total is $%.2f. Thank you for your purchase!\n", total);
                    } else {
                        System.out.println("Your cart is empty.");
                    }
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting the app. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}