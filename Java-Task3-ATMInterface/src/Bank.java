import java.util.ArrayList;

public class Bank {

    private Account account;
    private ArrayList<Transaction> history;

    public Bank() {

        account = new Account("admin", "1234", 10000);
        history = new ArrayList<>();
    }

    public Account getAccount() {
        return account;
    }

    public ArrayList<Transaction> getHistory() {
        return history;
    }

}