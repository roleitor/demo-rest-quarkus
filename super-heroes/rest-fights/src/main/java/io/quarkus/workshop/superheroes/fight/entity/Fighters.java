package io.quarkus.workshop.superheroes.fight.entity;

import io.quarkus.workshop.superheroes.fight.entity.client.Hero;
import io.quarkus.workshop.superheroes.fight.entity.client.Villain;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import jakarta.validation.constraints.NotNull;

@Schema(description = "A fight between one hero and one villain")
public class Fighters {

    @NotNull
    public Hero hero;
    @NotNull
    public Villain villain;

}
