package edu.uclm.esi.http;

import edu.uclm.esi.exceptions.MovimientoIlegalException;
import edu.uclm.esi.models.Move;
import edu.uclm.esi.models.Tablero4R;
import edu.uclm.esi.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @GetMapping("/start")
    public Tablero4R start() {
        return matchService.newMatch();
    }

    @GetMapping("/tableros")
    public List<Tablero4R> getAll() {
        return matchService.getAll();
    }

    @PostMapping("/{uuid}/poner")
    public Tablero4R poner(
            @RequestParam(value = "uuid") UUID uuid,
            @RequestBody Move move
    ) throws MovimientoIlegalException {
        return matchService.poner(uuid, move);
    }


}
