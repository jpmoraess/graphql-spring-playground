package br.com.moraessit.graphql.sec01.lec02;

import br.com.moraessit.graphql.sec01.lec02.dto.AgeRangeFilter;
import br.com.moraessit.graphql.sec01.lec02.dto.Customer;
import br.com.moraessit.graphql.sec01.lec02.service.CustomerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @QueryMapping
    public Flux<Customer> customers() {
        return customerService.customers();
    }

    @QueryMapping
    public Mono<Customer> customerById(@Argument Integer id) {
        return customerService.customerById(id);
    }

    @QueryMapping
    public Flux<Customer> customersNameContains(@Argument String name) {
        return customerService.customersNameContains(name);
    }

    @QueryMapping
    public Flux<Customer> customersByAgeRange(@Argument AgeRangeFilter filter) {
        return customerService.customersByAgeRange(filter);
    }
}
