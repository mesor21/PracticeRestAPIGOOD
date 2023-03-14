package com.example.testInterface.service;

import com.example.testInterface.entity.Lighting;

import java.util.List;

public interface ILightingService {
    List<Lighting> getList();
    void saveNewLighting();
    void deleteLighting(String id);
    Lighting getLightingID(String id);
    Lighting update(Lighting lighting);
    void switchLight(String id);
}
