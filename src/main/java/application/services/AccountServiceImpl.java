package application.services;

import application.dao.CustomerDaoException;
import application.pojo.Account;
import application.pojo.Customer;
import application.pojo.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    CustomerService customerService;

    @Autowired
    TransactionService transactionService;

    private static AtomicInteger idCounter = new AtomicInteger();

    @Override
    public void openAccount(int customerId, int initialValue) throws CustomerDaoException {
        Account account = createNewAccount(customerId);

        if (initialValue > 0) {
            List<Transaction> transactions = account.getTransactions();

            transactions.add(transactionService.createTransaction(initialValue));
        }
    }

    private Account createNewAccount(int customerId) throws CustomerDaoException {
        Optional<Customer> customerOptional = customerService.getCustomer(customerId);
        if (!customerOptional.isPresent()) {
            throw new CustomerDaoException("Not existing customer");
        } else {
            Customer customer = customerOptional.get();
            Account account = new Account(idCounter.getAndIncrement());
            List<Account> accountList = customer.getAccounts();

            accountList.add(account);
            return account;
        }
    }
}
