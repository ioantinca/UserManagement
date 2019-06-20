package resources;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pojo.Greeting;
import pojo.Transaction;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CustomerResource {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

//    @RequestMapping("/transaction")
//    public Transaction getTransaction(@RequestParam(value="credit", defaultValue="12") Integer credit) {
//        return new Transaction(counter.incrementAndGet(), credit);
//    }

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}
