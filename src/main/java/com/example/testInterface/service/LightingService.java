package com.example.testInterface.service;

import com.example.testInterface.entity.Lighting;
import com.example.testInterface.repository.YAMLRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LightingService{

    @Autowired
    YAMLRepo yamlRepo;

    public List<Lighting> getList() {
        return yamlRepo.getAll();
    }
    @Async
    public void saveNewLighting() {
        Lighting newL = new Lighting();
        yamlRepo.create(newL);
        System.out.println("Create new empty object");
    }
    @Async
    public void deleteLighting(String id) {
        yamlRepo.delete(Long.parseLong(id));
    }
    @Async

    public Lighting getLightingID(String id) {
        return yamlRepo.getByID(Long.parseLong(id));
    }

    //middleware
    @Async
    public Lighting update(Lighting lighting) {
        yamlRepo.update(lighting);
        return yamlRepo.getByID(lighting.getId());
    }
}
