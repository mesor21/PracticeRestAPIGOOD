package com.example.testInterface.controller;

import com.example.testInterface.entity.Lighting;
import com.example.testInterface.service.ILightingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/")
public class LightingAPI {
    @Autowired
    ILightingService lightingService;
    @Async
    @GetMapping("/main")
    public ResponseEntity<List<Lighting>> getAllLighting(){
        System.out.println("Get Lighting list for main page");
        return new ResponseEntity<>(lightingService.getList(), HttpStatus.OK);
    }

    @Async
    @PostMapping("/create")
    public List<Lighting> createNew(){
        return lightingService.getList();
    }

    @Async
    @GetMapping("/edit/{id}")
    public Lighting getForEdit(@PathVariable("id") String id){
        return lightingService.getLightingID(id);
    }

    @Async
    @PostMapping("/edit/{id}")
    public ResponseEntity<?> saveEdit(@RequestBody Lighting lighting){
        lightingService.update(lighting);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @Async
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id){
        lightingService.deleteLighting(id);
    }
    @Async
    @GetMapping("/info/switchLight/{id}")
    public void switchLight(@PathVariable("id") String id) {
        lightingService.switchLight(id);
    }
}
