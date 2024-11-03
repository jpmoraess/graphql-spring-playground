package br.com.moraessit.graphql.sec01.lec02.service;

import br.com.moraessit.graphql.sec01.lec02.dto.AgeRangeFilter;
import br.com.moraessit.graphql.sec01.lec02.dto.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    public Mono<Customer> customerById(Integer id) {
        return flux.filter(c -> c.id().equals(id))
                .next();
    }

    public Flux<Customer> customersNameContains(String name) {
        return flux.filter(c -> c.name().contains(name));
    }

    public Flux<Customer> customersByAgeRange(AgeRangeFilter filter) {
        return flux.filter(c -> c.age() >= filter.minAge() && c.age() <= filter.maxAge());
    }
}
