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
import java.util.Optional;
import java.util.UUID;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public Tablero4R newMatch() {
        return matchRepository.create();
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
        char[][] casillas = tablero.getCasillas();
        int col = move.getCol();
        validateMove(tablero, move);
        for (int i = Tablero4R.ROW - 1; i >= 0; i--) {
            if (casillas[i][col] == Character.MIN_VALUE) {
                casillas[i][col] = move.getColor();
                tablero.setLastColor(move.getColor());
                return tablero;
            }
        }
        tablero.print2D();

        return tablero;
    }

    private static void validateMove(Tablero4R t, Move m) throws MovimientoIlegalException {
        int col = m.getCol();
        if (!(col >= 0 && col < Tablero4R.COL && t.getCasillas()[0][col] == Character.MIN_VALUE))
            throw new MovimientoIlegalException("Illegal Move");

        if (t.getLastColor() == m.getColor()) {
            throw new MovimientoIlegalException("Not your turn");
        }
    }


}
