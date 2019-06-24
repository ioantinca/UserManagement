package application;

import application.dao.CustomerDao;
import application.dao.CustomerDaoException;
import application.pojo.Customer;
import application.services.CustomerResponse;
import application.services.CustomerService;
import application.services.CustomerServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class CustomerServiceTest {

    @MockBean
    private CustomerDao customerDao;

    @TestConfiguration
    static class CustomerServiceTestConfiguration {

        @Bean
        public CustomerService customerService() {
            return new CustomerServiceImpl();
        }
    }

    @Autowired
    private CustomerService customerService;

    @Test(expected = CustomerDaoException.class)
    public void notExistingCustomerThrowsException() throws CustomerDaoException {
        customerService.getCustomerDetails(1);
    }

    @Test
    public void getCustomerDetails() throws CustomerDaoException {
        Customer customer = new Customer("Doe", "Jhon");

        Mockito.when(customerDao.get(1))
                .thenReturn(Optional.of(customer));

        CustomerResponse customerResponse =  customerService.getCustomerDetails(1);

        assertEquals(customerResponse.getId(), customer.getId());
        assertEquals(customerResponse.getName(), customer.getName());
        assertEquals(customerResponse.getSurname(), customer.getSurname());
    }
}
