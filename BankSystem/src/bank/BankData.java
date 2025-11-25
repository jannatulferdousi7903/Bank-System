package bank;

import java.util.HashMap;

public class BankData {

    // Account class
    public static class Account {
        public String accNumber;
        public double balance;
        public double initialBalance;

        public Account(String accNumber, double balance) {
            this.accNumber = accNumber;
            this.balance = balance;
            this.initialBalance = balance;
        }
    }

    // Global Storage for all accounts
    public static HashMap<String, Account> accounts = new HashMap<>();
}
