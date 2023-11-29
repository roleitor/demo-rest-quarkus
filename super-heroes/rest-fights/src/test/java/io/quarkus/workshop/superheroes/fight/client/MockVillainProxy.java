package io.quarkus.workshop.superheroes.fight.client;

import io.quarkus.test.Mock;
import io.quarkus.workshop.superheroes.fight.entity.client.Villain;
import io.quarkus.workshop.superheroes.fight.service.client.VillainProxy;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.ApplicationScoped;

@Mock
@ApplicationScoped
@RestClient
public class MockVillainProxy implements VillainProxy {

    @Override
    public Villain findRandomVillain() {
        return DefaultTestVillain.INSTANCE;
    }
}
