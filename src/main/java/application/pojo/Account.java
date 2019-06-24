package application.pojo;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private final Integer id;
    private final List<Transaction> transactions;

    public Account(Integer id) {
        this.id = id;
        this.transactions = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
