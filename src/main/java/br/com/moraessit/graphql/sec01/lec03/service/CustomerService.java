package br.com.moraessit.graphql.sec01.lec03.service;

import br.com.moraessit.graphql.sec01.lec03.dto.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CustomerService {

    private final Flux<Customer> flux = Flux.just(
            new Customer(1, "John", 27, "Campinas"),
            new Customer(2, "Dessa", 28, "Campinas"),
            new Customer(3, "Sandra", 65, "Campinas"),
            new Customer(4, "Luiza", 32, "Campinas")
    );

    public Flux<Customer> customers() {
        return flux;
    }
}
