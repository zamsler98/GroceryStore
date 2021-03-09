import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    ArrayList<Product> products;
    ArrayList<User> users;

    public Store(String fileName) throws FileNotFoundException {
        products = new ArrayList<Product>();
        users = new ArrayList<User>();
        Scanner input = new Scanner(new File(fileName));
        loadStore(input);
    }

    private void loadStore(Scanner input) {
        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.equals("")) {
                break;
            }
            Scanner scannerLine = new Scanner(line);
            Product product = new Product(scannerLine);
            products.add(product);
        }

        while (input.hasNextLine()) {
            String line = input.nextLine();
            Scanner scannerLine = new Scanner(line);
            Store storeVar = this;
            User user = User.createUser(scannerLine, storeVar);     //this == store object
            users.add(user);
        }

    }


    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < products.size(); i++) {
            res += products.get(i).toString() + "\n";
        }
        return res;
    }

    public User getUserByUsername(String username) {
        for (int i = 0; i < users.size(); i++) {
            User currentUser = users.get(i);
            if (currentUser.getUsername().equals(username)) {
                return currentUser;
            }
        }
        return null;
    }

    public Product getProductByName(String productName) {
        for (int i = 0; i < products.size(); i++) {
            Product currentProduct = products.get(i);
            if (currentProduct.getName().equals(productName)) {
                return currentProduct;
            }
        }
        return null;
    }
}
