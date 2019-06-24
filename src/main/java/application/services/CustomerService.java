package application.services;

import application.dao.CustomerDaoException;
import application.pojo.Customer;

import java.util.Optional;

public interface CustomerService {

    Optional<Customer> getCustomer(int customerId);

    CustomerResponse getCustomerDetails(int customerId) throws CustomerDaoException;
}
