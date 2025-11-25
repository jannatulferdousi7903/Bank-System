package bank;

import java.util.HashMap;

public class AccountInfo {

    public static HashMap<String, AccountInfo> accounts = new HashMap<>();

    public String accNo;
    public String name;
    public double initialBalance;
    public double currentBalance;
    public double totalDeposit;
    public double totalWithdraw;

    public AccountInfo(String accNo, String name, double initialBalance, double currentBalance, double totalDeposit, double totalWithdraw) {
        this.accNo = accNo;
        this.name = name;
        this.initialBalance = initialBalance;
        this.currentBalance = currentBalance;
        this.totalDeposit = totalDeposit;
        this.totalWithdraw = totalWithdraw;
    }
}
