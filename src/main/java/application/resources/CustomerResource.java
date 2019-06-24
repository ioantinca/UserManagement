package application.resources;


import application.dao.CustomerDaoException;
import application.services.AccountService;
import application.services.CustomerResponse;
import application.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CustomerResource {

    @Autowired
    AccountService accountService;

    @Autowired
    CustomerService customerService;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = RequestMethod.POST, value = "/openAccount/{customerId}")
    public void openAccount(@PathVariable("customerId") int customerId, @RequestParam(value="initialValue", defaultValue = "0") int initialValue) throws CustomerDaoException {
        accountService.openAccount(customerId, initialValue);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getCustomerDetails")
    public CustomerResponse getCustomerDetails(@RequestParam("customerId") int customerId) throws CustomerDaoException {
        return customerService.getCustomerDetails(customerId);
    }
}
