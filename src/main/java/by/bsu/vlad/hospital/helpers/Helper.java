package by.bsu.vlad.hospital.helpers;

import by.bsu.vlad.hospital.entities.BaseEntity;

import java.util.ArrayList;

public class Helper {
    public static <T extends BaseEntity> T getEntityById(ArrayList<T> entities, String id) {
        return entities
                .stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
