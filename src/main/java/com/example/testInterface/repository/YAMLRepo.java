package com.example.testInterface.repository;

import com.example.testInterface.entity.Lighting;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class YAMLRepo {
    private static String fileP = "src/main/resources/yamlFiles/yaml.yaml";
    private final String fileID = "yamlFiles/yaml.yaml";
    ClassPathResource resource = new ClassPathResource(fileID);
    InputStream inputStream = resource.getInputStream();
    ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

    private final AtomicInteger lastId = new AtomicInteger(Math.toIntExact(getLastId()));

    public YAMLRepo() throws IOException {
    }

    @Async
    public Long generateCardId() {
        return (long) lastId.incrementAndGet();
    }

    @Async
    public Long getLastId() {
        long lastID = 0;
        try {
            List<Lighting> lightings = objectMapper.readValue(inputStream, new TypeReference<>() {
            });
            if (lightings != null && !lightings.isEmpty()) {
                lastID = lightings.get(lightings.size() - 1).getId();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Math.max(lastID, 0);
    }


    @Async
    public void delete(Long id) {
        List<Lighting> lightings = getAll();
        for (Iterator<Lighting> iterator = lightings.iterator(); iterator.hasNext();) {
            Lighting lighting = iterator.next();
            if (Objects.equals(lighting.getId(), id)) {
                iterator.remove();
                break; // Stop iterating after removing the element
            }
        }
        try {
            objectMapper.writeValue(new File(fileP), lightings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Async
    public void update(Lighting lighting) {
        List<Lighting> cards = getAll();
        for (int i = 0; i < cards.size(); i++) {
            if (Objects.equals(cards.get(i).getId(), lighting.getId())) {
                cards.set(i, lighting);
                break;
            }
        }
        try {
            objectMapper.writeValue(new File(fileP), cards);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Async
    public void create(Lighting lighting) {
        try {
            List<Lighting> lightings = objectMapper.readValue(new File(fileP), new TypeReference<>() {
            });
            if (lightings == null) {
                lightings = new ArrayList<>();
            }
            lighting.setId(generateCardId());
            lightings.add(lighting);
            objectMapper.writeValue(new File(fileP), lightings);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }


    @Async
    public List<Lighting> getAll()  {
        try{
            return objectMapper.readValue(new File(fileP), new TypeReference<>() {
            });
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Async
    public Lighting getByID(Long id){
        List<Lighting> lightings = getAll();
        for(Lighting lighting: lightings){
            if (lighting.getId() == id) {
                return lighting;
            }
        }
        return null;
    };

}
