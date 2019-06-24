package application.services;

import application.pojo.Customer;
import application.pojo.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CustomerResponse {
    private Integer id;
    private final String name;
    private final String surname;
    private List<Transaction> transactions;
    private Integer balance;

    public CustomerResponse(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.surname = customer.getSurname();
        this.transactions = new ArrayList<>();
        customer.getAccounts().forEach(account -> transactions.addAll(account.getTransactions()));
        this.balance = transactions.stream().mapToInt(Transaction::getCredit).sum();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Integer getBalance() {
        return balance;
    }
}
