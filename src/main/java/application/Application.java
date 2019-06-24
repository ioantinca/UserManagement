package application;

import application.dao.Dao;
import application.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

    @Autowired
    Dao<Customer> customerDao;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void init() {
        customerDao.save(new Customer("Doe", "Jhon"));
        customerDao.save(new Customer("Messi","Lionel"));
        customerDao.save(new Customer("James","Hetfield"));

        System.out.println("service from @service");
    }

}
