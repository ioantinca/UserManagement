package pojo;

public class Transaction {
    private final long id;
    private final Integer credit;

    public Transaction(long id, Integer credit) {
        this.id = id;
        this.credit = credit;
    }

    public long getId() {
        return id;
    }

    public Integer getCredit() {
        return credit;
    }
}
