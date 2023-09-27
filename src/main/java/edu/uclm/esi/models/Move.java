package edu.uclm.esi.models;

import edu.uclm.esi.http.MatchController;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class Move {
    @AllArgsConstructor
    @Getter
    public enum Colores {
        RED("RED"), AZUL("AZUL");
        private final String name;
    }

    private int col;
    private int row;
    private Colores color;
}
