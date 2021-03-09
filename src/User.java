import java.util.Scanner;

public abstract class User {
    private String username;
    private String password;
    protected Store store;
    public User(String username, String password, Store store) {
        this.username = username;   //this == user object
        this.password = password;
        this.store = store;
    }

    public abstract void loginAction();     //All subclasses of User must override this method

    public String getUsername() {
        return username;
    }

    public boolean validCredentials(String username, String password) {
        return username.equals(this.username) && password.equals(this.password);
    }

    //Factory Method
    public static User createUser(Scanner line, Store store) {
        String typeOfUser = line.next();
        String username = line.next();
        String password = line.next();
        if (typeOfUser.equals("admin")) {
            return new Admin(username, password, store);
        }
        else if (typeOfUser.equals("employee")) {
            return new Employee(username, password, store);
        }
        else {
            return new Customer(username, password, store);
        }
    }

}
