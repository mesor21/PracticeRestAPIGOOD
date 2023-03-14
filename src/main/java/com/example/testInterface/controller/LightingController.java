package com.example.testInterface.controller;

import com.example.testInterface.entity.Lighting;
import com.example.testInterface.service.ILightingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class LightingController {

    @Autowired
    ILightingService lightingService;

    public LightingController(ILightingService lightingService) {
        this.lightingService = lightingService;
    }

    @GetMapping("")
    public String test(Model model) {
        model.addAttribute("list", lightingService.getList());
        return "mainPage";
    }



    @PostMapping("/create")
    public String createNewLighting() {
        lightingService.saveNewLighting();
        System.out.println("Create new object");
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String getLighting(@PathVariable("id") String id, Model model) {
        List<Lighting> arr = new ArrayList<>();
        arr.add(lightingService.getLightingID(id));
        model.addAttribute("lighting", arr);
        return "editLighting";
    }

    @PostMapping("/edit/{id}")
    public String editLighting(@PathVariable("id") String id,
                               @RequestParam(value = "collor_red", required = false) String collor_red,
                               @RequestParam(value = "collor_blue", required = false) String collor_blue,
                               @RequestParam(value = "collor_green", required = false) String collor_green,
                               @RequestParam(value = "power_Wat", required = false) String power_Wat,
                               @RequestParam(value = "lux", required = false) String lux,
                               @RequestParam(value = "uptime_days", required = false) String uptime_days,
                               @RequestParam(value = "status", required = false) String status) {
        Lighting lighting = new Lighting(
                Long.parseLong(id),
                Integer.parseInt(collor_red),
                Integer.parseInt(collor_blue),
                Integer.parseInt(collor_green),
                Double.parseDouble(power_Wat),
                Integer.parseInt(lux),
                Integer.parseInt(uptime_days),
                Boolean.getBoolean(status));

        lightingService.update(lighting);
        System.out.println("Save object controller");
        return "redirect:/";

    }

    @GetMapping("error")
    public String error() {
        return "test";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        lightingService.deleteLighting(id);
        return "redirect:/";
    }

    @GetMapping("/info/get")
    public String get4Buisnes(Model model) {
        model.addAttribute("list", lightingService.getList());
        return "list4Buisnes";
    }

    @GetMapping("/info/switchLight/{id}")
    public String switchLight(@PathVariable("id") String id) {
        lightingService.switchLight(id);
        return "redirect:/info/get";
    }
}
