package application.dao;

import application.pojo.Customer;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class CustomerDao implements Dao<Customer> {

    private List<Customer> customers;

    public CustomerDao() {
        customers = new ArrayList<>();
    }

    @Override
    public Optional<Customer> get(int id) {
        return Optional.ofNullable(customers.get(id));
    }

    @Override
    public Collection<Customer> getAll() {
        return customers.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public int save(Customer customer) {
        customers.add(customer);
        int index = customers.size() - 1;
        customer.setId(index);
        return index;
    }

    @Override
    public void update(Customer customer) {
        customers.set(customer.getId(), customer);
    }

    @Override
    public void delete(Customer customer) {
        customers.set(customer.getId(), null);
    }
}
