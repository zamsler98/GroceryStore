import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Store store = new Store("Store.txt");
        System.out.println(store);
        Scanner input = new Scanner(System.in);
        System.out.println("Enter in your username");
        String username = input.nextLine();
        System.out.println("Enter in your password");
        String password = input.nextLine();
        User currentUser = store.getUserByUsername(username);
        if (currentUser != null && currentUser.validCredentials(username, password)) {
            currentUser.loginAction();
        }
        else {
            System.out.println("Invalid login info");
        }
    }
}



/*

MVP - read products from file, print to console
Features -  Users are able to login using username and password
            Employees that restock products
            Admin that restocks products
            Customer that buys products
            Admin create/remove users
            Save store back to text file

Grocery store

List of products, quantity, price, department
Read in products from file

Users
username password
login

Customers
purchase items

Employees
stock more items

Admins
stock more items
add/remove users


 */