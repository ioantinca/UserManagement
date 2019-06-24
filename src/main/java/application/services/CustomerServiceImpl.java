package application.services;

import application.dao.CustomerDao;
import application.dao.CustomerDaoException;
import application.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    private static AtomicInteger idCounter = new AtomicInteger();

    @Override
    public Optional<Customer> getCustomer(int customerId) {
        return customerDao.get(customerId);
    }

    @Override
    public CustomerResponse getCustomerDetails(int customerId) throws CustomerDaoException {
        Optional<Customer> customerOptional = customerDao.get(customerId);
        if (!customerOptional.isPresent()) {
            throw new CustomerDaoException("Not existing customer");
        } else {
            Customer customer = customerOptional.get();
            return new CustomerResponse(customer);
        }
    }
}
