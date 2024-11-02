package br.com.moraessit.graphql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class GraphQLController {

    @QueryMapping("sayHello")
    public Mono<String> helloWorld() {
        return Mono.just("Hello World")
                .delayElement(Duration.ofMillis(800));
    }

    @QueryMapping
    public Mono<String> sayHelloTo(@Argument("name") String value) {
        return Mono.fromSupplier(() -> "Hello " + value)
                .delayElement(Duration.ofMillis(800));
    }

    @QueryMapping
    public Mono<Integer> random() {
        return Mono.just(ThreadLocalRandom.current().nextInt(1, 1000))
                .delayElement(Duration.ofMillis(1500));
    }
}
