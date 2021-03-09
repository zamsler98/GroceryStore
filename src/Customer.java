import java.util.Scanner;

public class Customer extends User {
    public Customer(String username, String password, Store store) {
        super(username, password, store);
    }

    @Override
    public void loginAction() {
        System.out.println("Hello " + getUsername() + ". What item would you like to buy?");
        Scanner input = new Scanner(System.in);
        String itemName = input.nextLine();
        Product selectedProduct = store.getProductByName(itemName);
        if (selectedProduct != null) {
            System.out.println("There are currently " + selectedProduct.getQuantity() + " in stock. How many would you like to purchase?");
            int amountBought = input.nextInt();
            int currentQuantity = selectedProduct.getQuantity();
            selectedProduct.setQuantity(currentQuantity - amountBought);
            double totalPrice = selectedProduct.getPrice() * amountBought;
            System.out.println("That will be "+totalPrice+" dollars. Thank you.");
        } else {
            System.out.println("We do not carry that product, sorry");
        }
    }
}
