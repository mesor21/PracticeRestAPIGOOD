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
    public boolean saveEdit(String id, String red, String green, String blue, String power, String lux, String uptime) {
        Lighting lighting = jsonRepo.getByID(Long.parseLong(id));

        if (red.equals("")) {
            lighting.setCollor_red(lighting.getCollor_red());
        } else {
            if (Integer.parseInt(red) > 255 | Integer.parseInt(red) < 0) {
                return true;
            }
            lighting.setCollor_red(Integer.parseInt(red));
        }

        if (green.equals("")) {
            lighting.setCollor_green(lighting.getCollor_green());
        } else {
            if (Integer.parseInt(green) > 255 | Integer.parseInt(green) < 0) {
                return true;
            }
            lighting.setCollor_green(Integer.parseInt(green));
        }

        if (blue.equals("")) {
            lighting.setCollor_blue(lighting.getCollor_blue());
        } else {
            if (Integer.parseInt(blue) > 255 | Integer.parseInt(blue) < 0) {
                return true;
            }
            lighting.setCollor_blue(Integer.parseInt(blue));
        }

        if (power.equals("")) {
            lighting.setPower_Wat(lighting.getPower_Wat());
        } else {
            if (Double.parseDouble(power) < 0) {
                return true;
            }
            lighting.setPower_Wat(Double.parseDouble(power));
        }

        if (lux.equals("")) {
            lighting.setLux(lighting.getLux());
        } else {
            if (Integer.parseInt(lux) < 0) {
                return true;
            }
            lighting.setLux(Integer.parseInt(lux));
        }

        if (uptime.equals("")) {
            lighting.setUptime_days(lighting.getUptime_days());
        } else {
            if (Integer.parseInt(uptime) < 0) {
                return true;
            }
            lighting.setUptime_days(Integer.parseInt(uptime));
        }
        jsonRepo.delete(Long.parseLong(id));
        jsonRepo.save(lighting);
        return false;
    }

    public void switchLight(String id) {
        Lighting lighting = jsonRepo.getByID(Long.parseLong(id));
        lighting.setStatus(!lighting.getStatus());
        jsonRepo.update(lighting);
    }
}
