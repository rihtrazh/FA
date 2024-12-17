package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


/**
 * Представляет сущность груза с подробностями о грузоотправке.
 * Этот класс аннотирован JPA для сопоставления его с таблицей базы данных
 */
@Entity
@Data
public class Cargo {
    private Integer ID;
    private String departureDate;
    private String deliveryDate;
    private String status;
    private String cargoType;
    private Double weight;
    private Double volume;
    private String sender;
    private String recipientAddress;
    private String deliveryRate;

    /**
     * Получает уникальный идентификатор груза
     * @return идентификатор груза
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getID() {
        return ID;
    }
}