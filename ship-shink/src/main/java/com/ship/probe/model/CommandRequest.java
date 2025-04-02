package com.ship.probe.model;

import lombok.Data;

import java.util.List;

@Data
public class CommandRequest {
    private List<String> commands;
}
