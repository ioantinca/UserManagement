package application;

import application.dao.CustomerDaoException;
import application.pojo.Customer;
import application.pojo.Transaction;
import application.services.AccountService;
import application.services.AccountServiceImpl;
import application.services.CustomerService;
import application.services.TransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
public class AccountServiceTest {

    @MockBean
    private TransactionService transactionService;

    @MockBean
    private CustomerService customerService;

    @TestConfiguration
    static class AccountServiceTestConfiguration {

        @Bean
        public AccountService accountService() {
            return new AccountServiceImpl();
        }
    }

    @Autowired
    private AccountService accountService;

    @Test(expected = CustomerDaoException.class)
    public void checkNotExistingCustomer() throws CustomerDaoException {
        accountService.openAccount(12, 30);
    }

    @Test
    public void createAccountInitialValueIsZero() throws CustomerDaoException {
        Customer customer = new Customer("Doe", "Jhon");

        Mockito.when(customerService.getCustomer(1))
                .thenReturn(Optional.of(customer));

        accountService.openAccount(1, 0);

        assertEquals(customer.getName(), "Doe");
        assertEquals(customer.getSurname(), "Jhon");
        assertEquals(customer.getAccounts().size(), 1);
        assertTrue(customer.getAccounts().get(0).getTransactions().isEmpty());

        System.out.println(customer);
    }

    @Test
    public void createAccountInitialValueIsHigherThanZero() throws CustomerDaoException {
        Customer customer = new Customer("Doe", "Jhon");

        Mockito.when(customerService.getCustomer(1))
                .thenReturn(Optional.of(customer));

        Mockito.when(transactionService.createTransaction(100))
                .thenReturn(new Transaction(100));

        accountService.openAccount(1, 100);

        assertEquals(customer.getName(), "Doe");
        assertEquals(customer.getSurname(), "Jhon");
        assertEquals(customer.getAccounts().size(), 1);
        assertFalse(customer.getAccounts().get(0).getTransactions().isEmpty());
        assertEquals(customer.getAccounts().get(0).getTransactions().get(0).getCredit().intValue(), 100);

        System.out.println(customer);
    }
}
