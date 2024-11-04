package br.com.moraessit.graphql.sec01.lec04.dto;

import java.util.UUID;

public record CustomerOrder(UUID id, String description) {
}
