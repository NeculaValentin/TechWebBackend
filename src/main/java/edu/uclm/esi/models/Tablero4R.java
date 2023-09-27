package edu.uclm.esi.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.UUID;

@AllArgsConstructor
@Data
public class Tablero4R {
    public static final int COL = 6;
    public static final int ROW = 7;
    private char lastColor = 'A';
    public Tablero4R() {
        //this.uuid = UUID.randomUUID();
        this.uuid = UUID.fromString("6be5be84-8c69-433f-8740-c5de3fe3df3c");
    }

    private UUID uuid;
    private char[][] casillas = new char[ROW][COL];

    public void print2D() {
        for (char[] row : casillas) System.out.println(Arrays.toString(row));
        System.out.println("\n");
    }
}
