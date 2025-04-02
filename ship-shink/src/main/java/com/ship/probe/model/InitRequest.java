package com.ship.probe.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InitRequest {
    private int gridWidth;
    private int gridHeight;
    private int startX;
    private int startY;
    private String direction;
    private List<Coordinate> obstacles;
}
