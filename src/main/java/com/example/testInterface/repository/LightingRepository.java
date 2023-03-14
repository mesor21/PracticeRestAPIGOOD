package com.example.testInterface.repository;

import com.example.testInterface.entity.Lighting;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
public class LightingRepository implements ILightingRepository {
    private final static String fileName = "C:\\Users\\prodg\\IdeaProjects\\PracticeRestAPIGOOD\\src\\main\\resources\\DataContext.json";
    private Gson gson;

    private Comparator<Lighting> idComparator = new Comparator<Lighting>() {
        @Override
        public int compare(Lighting o1, Lighting o2) {
            return o1.getId().compareTo(o2.getId());
        }
    };

    public LightingRepository(Gson gson) {
        this.gson = gson;
    }

    private List<Lighting> loadData() {
        var list = new ArrayList<Lighting>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            list = gson.fromJson(bufferedReader, new TypeToken<List<Lighting>>() {
            }.getType());
            bufferedReader.close();
            System.out.println("Lighting objects have been read from " + fileName + " file.");
            list.sort(idComparator);
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private void writeData(List<Lighting> lightings) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            gson.toJson(lightings, fileWriter);
            fileWriter.close();
            System.out.println("Lighting objects have been saved to " + fileName + " file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Lighting getByID(Long myClassId) {
        List<Lighting> myClassList = loadData();
        int classId = -1;
        for (int i = 0; i < myClassList.size(); i++) {
            if (myClassList.get(i).getId().equals(myClassId)) {
                classId = i;
                break;
            }
        }
        return myClassList.get(classId);
    }

    public void delete(Long myClassId) {
        List<Lighting> myClassList = loadData();
        myClassList.removeIf(x -> myClassId - 1 > 0 && x.getId() == myClassId);
        writeData(myClassList);
    }

    public void save(Lighting x) {
        List<Lighting> myClassList = loadData();
        if (myClassList.isEmpty()) {
            x.setId(Long.valueOf(1));
        } else {
            x.setId(Long.valueOf(myClassList.get(myClassList.size() - 1).getId() + 1));
        }
        myClassList.add(x);
        writeData(myClassList);
    }

    public List<Lighting> findAll() {
        List<Lighting> myClassList = loadData();
        return myClassList;
    }

    public Lighting update(Lighting lighting) {
        List<Lighting> lightings = loadData();
        var id = Integer.parseInt(lightings.stream()
                .filter(x -> x.getId()==Long.parseLong(lighting.getId().toString()))
                .findFirst().get().getId().toString())-1;
        if (!lightings.isEmpty() && lighting != null) {
            lightings.set(
                    id,
                    lighting);}
        writeData(lightings);
        lightings = loadData();
        return lightings.stream().filter(x->(x.getId())==lighting.getId()).toList().get(0);
    }
}
