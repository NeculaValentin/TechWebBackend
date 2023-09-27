package edu.uclm.esi.services;

import edu.uclm.esi.exceptions.MovimientoIlegalException;
import edu.uclm.esi.models.Move;
import edu.uclm.esi.models.Tablero4R;
import edu.uclm.esi.repositorios.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public Tablero4R newMatch() {
        Tablero4R tablero = new Tablero4R();
        matchRepository.add(tablero);
        return tablero;
    }

    public List<Tablero4R> getAll() {
        return matchRepository.getAll();
    }

    public Tablero4R getOrElseThrow(UUID uuid) {
        return getNullable(uuid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No Encuentro esa partida"));
    }

    public Optional<Tablero4R> getNullable(UUID uuid) {
        return matchRepository.get(uuid);
    }

    public Tablero4R poner(UUID uuid, Move move) throws MovimientoIlegalException {
        Tablero4R tablero = getOrElseThrow(uuid);
        String[][] casillas = tablero.getCasillas();
        int casillaLibre = -1;
        if( casillaLibre == -1)
            throw new MovimientoIlegalException(); //TODO
        casillas[move.getCol()][move.getRow()] = move.getColor().getName();
        return tablero;
    }


}
