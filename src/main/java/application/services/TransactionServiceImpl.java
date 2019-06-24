package application.services;

import application.pojo.Transaction;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Override
    public Transaction createTransaction(int credit) {
        return new Transaction(credit);
    }
}
