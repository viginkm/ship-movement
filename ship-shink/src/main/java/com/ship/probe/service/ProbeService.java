package com.ship.probe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ship.probe.constant.Direction;
import com.ship.probe.model.Coordinate;

@Service
public class ProbeService {
	

	    private int gridWidth, gridHeight;
	    private Coordinate currentPosition;
	    private Direction currentDirection;
	    private List<Coordinate> obstacles = new ArrayList<>();
	    private List<Coordinate> visited = new ArrayList<>();

	    public void initialize(int gridWidth, int gridHeight, int startX, int startY, String direction, List<Coordinate> obstacles) {
	        this.gridWidth = gridWidth;
	        this.gridHeight = gridHeight;
	        this.currentPosition = new Coordinate(startX, startY);
	        this.currentDirection = Direction.valueOf(direction);
	        this.obstacles = obstacles;
	        visited.clear();
	        visited.add(new Coordinate(startX, startY));
	    }

}

