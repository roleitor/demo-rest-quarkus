package io.quarkus.workshop.superheroes.statistics.entity;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class FightDeserializer extends ObjectMapperDeserializer<Fight> {

    public FightDeserializer() {
        super(Fight.class);
    }
}
