package financemanager;

import java.util.*;

public class Wallet {
    private double balance;
    private List<Transaction> transactions;
    private Map<String, BudgetCategory> budgetCategories;

    public Wallet() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
        this.budgetCategories = new HashMap<>();
    }

    public void addTransaction(String category, double amount, boolean isIncome) {
        transactions.add(new Transaction(category, amount, isIncome));  // Ensure Transaction is accessible
        balance += isIncome ? amount : -amount;

        if (!budgetCategories.containsKey(category)) {
            budgetCategories.put(category, new BudgetCategory(category));
        }
        budgetCategories.get(category).addTransaction(amount, isIncome);
    }

    public void setBudget(String category, double budget) {
        budgetCategories.putIfAbsent(category, new BudgetCategory(category));
        budgetCategories.get(category).setBudget(budget);
    }

    public double getBalance() {
        return balance;
    }

    public void printSummary() {
        System.out.println("Current Balance: " + balance);
        System.out.println("Transactions:");
        for (Transaction t : transactions) {
            System.out.println(t);
        }

        System.out.println("Budgets:");
        for (BudgetCategory category : budgetCategories.values()) {
            System.out.println(category);
        }
    }
}
