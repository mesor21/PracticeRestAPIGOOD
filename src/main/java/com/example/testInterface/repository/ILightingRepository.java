package com.example.testInterface.repository;

import com.example.testInterface.entity.Lighting;

import java.util.List;
public interface ILightingRepository {
    Lighting getByID(Long myClassId);
    void delete(Long myClassId);
    void save(Lighting x);
    List<Lighting> findAll();
    Lighting update(Lighting lighting);
}
