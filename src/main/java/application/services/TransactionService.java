package application.services;

import application.pojo.Transaction;

public interface TransactionService {

    Transaction createTransaction(int credit);

}
