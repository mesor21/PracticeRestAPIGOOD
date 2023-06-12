package com.example.testInterface.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Lighting {
    private Long id;
    private int collor_red;//
    private int collor_blue;//цветовой тон излучения
    private int collor_green;//
    private double power_Wat;
    private int lux;
    private int uptime_days;
    private boolean status;

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}