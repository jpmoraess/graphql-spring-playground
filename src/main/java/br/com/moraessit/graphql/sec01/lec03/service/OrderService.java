package br.com.moraessit.graphql.sec01.lec03.service;

import br.com.moraessit.graphql.sec01.lec03.dto.CustomerOrder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class OrderService {

    private final Map<String, List<CustomerOrder>> map = Map.of(
            "John", List.of(
                    new CustomerOrder(UUID.randomUUID(), "John-Product-1"),
                    new CustomerOrder(UUID.randomUUID(), "John-Product-2")
            ),
            "Dessa", List.of(
                    new CustomerOrder(UUID.randomUUID(), "Dessa-Product-1"),
                    new CustomerOrder(UUID.randomUUID(), "Dessa-Product-2"),
                    new CustomerOrder(UUID.randomUUID(), "Dessa-Product-3")
            )
    );

    public Flux<CustomerOrder> ordersByCustomerName(String name) {
        return Flux.fromIterable(map.getOrDefault(name, Collections.emptyList()));
    }
}
