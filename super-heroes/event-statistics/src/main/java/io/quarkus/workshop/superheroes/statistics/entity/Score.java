package io.quarkus.workshop.superheroes.statistics.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Score {
    public String name;
    public int score;

    public Score() {
        this.score = 0;
    }
}
