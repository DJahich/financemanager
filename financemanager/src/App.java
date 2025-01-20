package financemanager;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FinanceManager manager = new FinanceManager();

        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Logout\n4. Add Transaction\n5. Set Budget\n6. View Summary\n7. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> {
                    System.out.print("Имя пользователя: ");
                    String username = scanner.nextLine();
                    System.out.print("Пароль: ");
                    String password = scanner.nextLine();
                    manager.register(username, password);
                }
                case 2 -> {
                    System.out.print("Имя пользователя: ");
                    String username = scanner.nextLine();
                    System.out.print("Пароль: ");
                    String password = scanner.nextLine();
                    manager.login(username, password);
                }
                case 3 -> manager.logout();
                case 4 -> {
                    User user = manager.getCurrentUser();
                    if (user == null) {
                        System.out.println("Необходимо войти в систему для продолжения.");
                        break;
                    }
                    System.out.print("Введите категорию: ");
                    String category = scanner.nextLine();
                    System.out.print("Введите сумму: ");
                    double amount = scanner.nextDouble();
                    System.out.print("Это доход? (true/false): ");
                    boolean isIncome = scanner.nextBoolean();Please login first
                    user.getWallet().addTransaction(category, amount, isIncome);
                }
                case 5 -> {
                    User user = manager.getCurrentUser();
                    if (user == null) {
                        System.out.println("Необходимо войти в систему для продолжения.");
                        break;
                    }
                    System.out.print("Введите категорию: ");
                    String category = scanner.nextLine();
                    System.out.print("Введите бюджет: ");
                    double budget = scanner.nextDouble();
                    user.getWallet().setBudget(category, budget);
                }
                case 6 -> {
                    User user = manager.getCurrentUser();
                    if (user == null) {
                        System.out.println("Необходимо войти в систему для продолжения.");
                        break;
                    }
                    user.getWallet().printSummary();
                }
                case 7 -> {
                    System.out.println("Exiting application...");
                    return;
                }
                default -> System.out.println("Некорректный выбор, попробуйте снова.");
            }
        }
    }
}
