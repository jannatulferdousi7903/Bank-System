package logic;

import java.io.*;
import java.util.ArrayList;


public class FileManager {

    private static final String FILE_PATH = "accounts.csv";

    // Load all accounts from CSV
    public static ArrayList<String[]> loadAccounts() {
        ArrayList<String[]> accounts = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                accounts.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return accounts;
    }

    // Find a single account by account number
    public static String[] findAccount(String accNo) {
        ArrayList<String[]> accounts = loadAccounts();

        for (String[] row : accounts) {
            if (row[0].equals(accNo)) { // row[0] = account number
                return row;
            }
        }

        return null; // Not found
    }
    
    public static void saveAccounts(ArrayList<String[]> list) {
    String filePath = "accounts.csv";

    try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filePath)))) {
        for (String[] row : list) {
            pw.println(String.join(",", row));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
 public static String generateAccountNumber() {

        int lastNumber = 0; // starting number

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length > 0 && data[0].startsWith("ACC")) {
                    try {
                        int num = Integer.parseInt(data[0].substring(3)); // remove "ACC"
                        lastNumber = Math.max(lastNumber, num);
                    } catch (Exception e) {}
                }
            }

        } catch (IOException e) {
            // file might not exist → ignore
        }

        return "ACC" + (lastNumber + 1);
    }

}  


