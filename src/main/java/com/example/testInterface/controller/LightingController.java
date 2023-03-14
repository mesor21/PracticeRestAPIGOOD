package com.example.testInterface.controller;

import com.example.testInterface.entity.Lighting;
import com.example.testInterface.service.ILightingService;
<<<<<<< HEAD
=======
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> e3a72249173588fc9bc707e9a04ffed988580031
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class LightingController {
<<<<<<< HEAD
    ILightingService lightingService;
=======

    @Autowired
    ILightingService lightingService;

    public LightingController(ILightingService lightingService) {
        this.lightingService = lightingService;
    }

>>>>>>> e3a72249173588fc9bc707e9a04ffed988580031
    @GetMapping("")
    public String test(Model model){
        model.addAttribute("list",lightingService.getList());
        return "mainPage";
    }
    @GetMapping("{id}")
    public String getLighting(@PathVariable("id")String id, Model model){
        List<Lighting> arr = new ArrayList<>();
        arr.add(lightingService.getLightingID(id));
        model.addAttribute("lighting",arr);
        return "editLighting";
    }
    @PostMapping("")
    public String createNewLighting(){
        lightingService.saveNewLighting();
        System.out.println("Create new object");
        return "redirect:/";
    }
    @PostMapping("{id}")
    public String edit_object(@PathVariable("id")String id, @RequestParam(value = "collor_red",required = false)String collor_red, @RequestParam(value = "collor_blue",required = false)String collor_blue, @RequestParam(value = "collor_green",required = false)String collor_green, @RequestParam(value = "power_Wat",required = false)String power_Wat, @RequestParam(value = "lux",required = false)String lux , @RequestParam(value = "uptime_days",required = false)String uptime_days){
        if(lightingService.saveEdit(id,collor_red,collor_green,collor_blue,power_Wat,lux,uptime_days)){
            return "redirect:/ERROR";
        }
        System.out.println("Save object");
        return "redirect:/";
    }
    @GetMapping("ERROR")
    public String error(){
        return "test";
    }

    @GetMapping("info/delete/{id}")
    public String delete(@PathVariable("id")String id){
        lightingService.deleteLighting(id);
        return "redirect:/";
    }
<<<<<<< HEAD
    @GetMapping("info/get")
=======
    @GetMapping("/info/get")
>>>>>>> e3a72249173588fc9bc707e9a04ffed988580031
    public String get4Buisnes(Model model){
        model.addAttribute("list",lightingService.getList());
        return "list4Buisnes";
    }
<<<<<<< HEAD
    @GetMapping("info/turnOn/{id}")
=======
    @GetMapping("/info/turnOn/{id}")
>>>>>>> e3a72249173588fc9bc707e9a04ffed988580031
    public String turnOn(@PathVariable("id")String id, Model model){
        lightingService.setLightingStatus(id,true);
        return "redirect:/info/get";
    }
<<<<<<< HEAD
    @GetMapping("info/turnOff/{id}")
=======
    @GetMapping("/info/turnOff/{id}")
>>>>>>> e3a72249173588fc9bc707e9a04ffed988580031
    public String turnOff(@PathVariable("id")String id, Model model){
        lightingService.setLightingStatus(id, false);
        return "redirect:/info/get";
    }
}
