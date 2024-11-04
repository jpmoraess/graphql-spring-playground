package br.com.moraessit.graphql.sec01.lec03;

import br.com.moraessit.graphql.sec01.lec03.dto.Customer;
import br.com.moraessit.graphql.sec01.lec03.dto.CustomerOrder;
import br.com.moraessit.graphql.sec01.lec03.service.CustomerService;
import br.com.moraessit.graphql.sec01.lec03.service.OrderService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

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

    @SchemaMapping(typeName = "Customer")
    public Flux<CustomerOrder> orders(Customer customer, @Argument Integer limit) {
        System.out.println("orders method invoked for " + customer.name());
        return orderService.ordersByCustomerName(customer.name())
                .take(limit);
    }
}
