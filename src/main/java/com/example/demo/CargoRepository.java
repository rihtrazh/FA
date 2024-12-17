package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Интерфейс репозитория для доступа к сущностям груза из базы данных.
 * Этот интерфейс расширяет JpaRepository для предоставления операций CRUD и пользовательских методов запросов.
 */
public interface CargoRepository extends JpaRepository<Cargo, Integer> {
    /**
     * Ищет грузы по ключевому слову, которое совпадает с любым из полей груза.
     * @param keyword ключевое слово для поиска
     * @return список грузов, соответствующих критериям поиска
     */
    @Query("SELECT p FROM Cargo p WHERE CONCAT(p.ID, p.departureDate, p.deliveryDate, p.status, p.cargoType, p.weight, p.volume, p.sender, p.recipientAddress, p.deliveryRate) LIKE %?1%")
    List<Cargo> search(String keyword);
}