package com.ship.probe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ship.probe.model.InitRequest;
import com.ship.probe.service.ProbeService;



@RestController
@RequestMapping("/probe")
public class ProbeController {

    @Autowired
    private ProbeService probeService;

    @PostMapping("/initialize")
    public ResponseEntity<String> initialize(@RequestBody InitRequest request) {
        probeService.initialize(
                request.getGridWidth(),
                request.getGridHeight(),
                request.getStartX(),
                request.getStartY(),
                request.getDirection(),
                request.getObstacles()
        );
        return ResponseEntity.ok("Probe Initialized");
    }
}
