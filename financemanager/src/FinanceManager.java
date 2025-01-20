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
            System.out.println("Пользователь уже существует.");
            return;
        }
        users.put(username, new User(username, password));
        System.out.println("Пользователь успешно создан.");
    }

    public void login(String username, String password) {
        User user = users.get(username);
        if (user == null || !user.checkPassword(password)) {
            System.out.println("Неверные логин или пароль.");
            return;
        }
        currentUser = user;
        System.out.println("Входи успешно выполнен. Добро пожаловать, " + username + "!");
    }

    public void logout() {
        if (currentUser != null) {
            currentUser = null;
            System.out.println("Выход выполнен успешно.");
        } else {
            System.out.println("Никто из пользователей в данный момент не выполнил вход.");
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
