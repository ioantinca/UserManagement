package application.pojo;

public class Transaction {
    private final Integer credit;

    public Transaction(Integer credit) {
        this.credit = credit;
    }

    public Integer getCredit() {
        return credit;
    }
}
