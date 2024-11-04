package br.com.moraessit.graphql.sec01.lec04;

import br.com.moraessit.graphql.sec01.lec04.dto.Customer;
import br.com.moraessit.graphql.sec01.lec04.dto.CustomerOrder;
import br.com.moraessit.graphql.sec01.lec04.service.CustomerService;
import br.com.moraessit.graphql.sec01.lec04.service.OrderService;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.List;

@Controller
public class CustomerController {

    private final CustomerService customerService;
    private final OrderService orderService;

    public CustomerController(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }

    @QueryMapping
    public Flux<Customer> customers() {
        return customerService.customers();
    }

    // fix N + 1 (BatchMapping)
    @BatchMapping(typeName = "Customer")
    public Flux<List<CustomerOrder>> orders(List<Customer> customers) {
        System.out.println("orders method invoked for " + customers);
        return orderService.ordersByCustomerNames(customers.stream().map(Customer::name).toList());
    }
}
