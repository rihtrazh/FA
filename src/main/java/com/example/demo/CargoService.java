package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервисный класс для обработки бизнес-логики, связанной с операциями над грузами.
 * Этот класс взаимодействует с CargoRepository для выполнения операций CRUD над сущностями груза.
 */
@Service
public class CargoService {
    @Autowired
    private CargoRepository repo;

    /**
     * Получает все грузы, при необходимости фильтруя по ключевому слову.
     * @param keyword ключевое слово для фильтрации грузов (может быть null)
     * @return список грузов
     */
    public List<Cargo> getAllCargos(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    /**
     * Сохраняет сущность в базе данных.
     * @param cargo груз, который нужно сохранить
     */
    public void saveCargo(Cargo cargo) {
        repo.save(cargo);
    }

    /**
     * Получает груз по его идентификатору.
     * @param id идентификатор груза, который нужно получить
     * @return груз с указанным идентификатором
     */
    public Cargo getCargo(Integer id) {
        return repo.findById(id).get();
    }

    /**
     * Удаляет груз по его идентификатору
     * @param id идентификатор груза, который нужно удалить
     */
    public void deleteCargo(Integer id) {
        repo.deleteById(id);
    }
}