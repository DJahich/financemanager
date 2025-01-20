package financemanager;

import java.util.*;

class FinanceManager {
    private Map<String, User> users;
    private User currentUser;

    public FinanceManager() {
        this.users = new HashMap<>();
        this.currentUser = null;
    }

    public void register(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("User already exists.");
            return;
        }
        users.put(username, new User(username, password));
        System.out.println("User registered successfully.");
    }

    public void login(String username, String password) {
        User user = users.get(username);
        if (user == null || !user.checkPassword(password)) {
            System.out.println("Invalid credentials.");
            return;
        }
        currentUser = user;
        System.out.println("Login successful. Welcome, " + username + "!");
    }

    public void logout() {
        if (currentUser != null) {
            currentUser = null;
            System.out.println("Logged out successfully.");
        } else {
            System.out.println("No user is currently logged in.");
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
