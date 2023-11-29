package io.quarkus.workshop.superheroes.fight.service.client;

import io.quarkus.workshop.superheroes.fight.entity.client.Hero;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/heroes")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "hero")
public interface HeroProxy {

    @GET
    @Path("/random")
    Hero findRandomHero();
}
