package io.quarkus.workshop.superheroes.villain.service;

import io.quarkus.workshop.superheroes.villain.entity.Villain;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;

//Declaracion del bens con arc para la inyeccion de dependencia
@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRED)
public class VillainService {
    @ConfigProperty(name = "level.multiplier", defaultValue="1.0") double levelMultiplier;
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Villain> findAllVillains() {
        return Villain.listAll();
    }

    @Transactional(Transactional.TxType.SUPPORTS)
    public Villain findVillainById(Long id) {
        return Villain.findById(id);
    }

    @Transactional(Transactional.TxType.SUPPORTS)
    public Villain findRandomVillain() {
        Villain randomVillain = null;
        while (randomVillain == null) {
            randomVillain = Villain.findRandom();
        }
        return randomVillain;
    }

    public Villain persistVillain(@Valid Villain villain) {
        villain.level = (int) Math.round(villain.level * levelMultiplier);
        villain.persist();
        return villain;
    }

    public Villain updateVillain(@Valid Villain villain) {
        Villain entity = Villain.findById(villain.id);
        entity.name = villain.name;
        entity.otherName = villain.otherName;
        entity.level = villain.level;
        entity.picture = villain.picture;
        entity.powers = villain.powers;
        return entity;
    }

    public void deleteVillain(Long id) {
        Villain villain = Villain.findById(id);
        villain.delete();
    }
}
