package edu.uclm.esi.repositorios;

import edu.uclm.esi.models.Tablero4R;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MatchRepository {
    private Map<UUID, Tablero4R> tableros = new HashMap<>();

    public void add(Tablero4R tablero){
        tableros.put(tablero.getUuid(), tablero);
    }

    public Optional<Tablero4R> get(UUID uuid){
        return Optional.ofNullable(tableros.get(uuid));
    }

    public List<Tablero4R> getAll() {
        return null;
    }
}
