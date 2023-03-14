package com.example.testInterface.service;

import com.example.testInterface.entity.Lighting;

import java.util.List;

public interface ILightingController {
    List<Lighting> getList();
    void saveNewLighting();
    void deleteLighting(String id);
    Lighting getLightingID(String id);
    boolean saveEdit(String id, String red, String green, String blue,String power, String lux, String uptime);
    void setLightingStatus(String id,boolean status);
}
