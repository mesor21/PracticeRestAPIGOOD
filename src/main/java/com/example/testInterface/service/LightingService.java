package com.example.testInterface.service;

import com.example.testInterface.entity.Lighting;
import com.example.testInterface.repository.ILightingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LightingService implements ILightingService {

    @Autowired
    ILightingRepository jsonRepo;

    public LightingService(ILightingRepository iLightingRepository) {
        this.jsonRepo = iLightingRepository;
    }

    public List<Lighting> getList() {
        return jsonRepo.findAll();
    }

    public void saveNewLighting() {
        Lighting newL = new Lighting();
        jsonRepo.save(newL);
        System.out.println("Create new empty object");
    }

    public void deleteLighting(String id) {
        jsonRepo.delete(Long.parseLong(id));
    }

    public Lighting getLightingID(String id) {
        return jsonRepo.getByID(Long.parseLong(id));
    }

    //middleware
    public Lighting update(Lighting lighting) {
        jsonRepo.update(lighting);
        return jsonRepo.getByID(lighting.getId());
    }

    public void switchLight(String id) {
        Lighting lighting = jsonRepo.getByID(Long.parseLong(id));
        lighting.setStatus(!lighting.getStatus());
        jsonRepo.update(lighting);
    }
}
