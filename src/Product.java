import java.util.Scanner;

public class Product {
    private String name;
    private String department;
    private int quantity;
    private double price;

    public Product(Scanner line) {
        //This code can throw errors if something goes wrong with text file
        //Groceries Banana 10 0.98
        department = line.next();
        name = line.next();
        quantity = line.nextInt();
        price = line.nextDouble();
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int newQuantity) {
        quantity = Math.max(newQuantity, 0);
    }

    public void setPrice(double newPrice) {
        price = Math.max(newPrice, 0);
    }

    @Override
    public String toString() {
        return department + " " + name + " " + quantity + " " + price;
    }
}
