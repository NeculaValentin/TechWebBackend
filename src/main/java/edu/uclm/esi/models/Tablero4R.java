package edu.uclm.esi.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
public class Tablero4R {
    public Tablero4R() {
        this.uuid = UUID.randomUUID();
    }

    private UUID uuid;
    private String[][] casillas = new String[6][7];
}
