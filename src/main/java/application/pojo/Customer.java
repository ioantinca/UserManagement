package application.pojo;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private Integer id;
    private final String name;
    private final String surname;
    private final List<Account> accounts;

    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.accounts = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
