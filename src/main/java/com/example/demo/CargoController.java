package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Контроллер для обработки HTTP-запросов, связанных с операциями над грузами.
 * Этот класс предоставляет конечные точки для создания, чтения, обновления и удаления записей о грузах.
 */
@Controller
public class CargoController {
    @Autowired
    private CargoService service;

    /**
     * Отображает индексную страницу со списком грузов
     * @param model модель для хранения атрибутов для представления
     * @param keyword ключевое слово для поиска грузов
     * @return имя представления, которое будет отображено
     */
    @GetMapping("/")
    public String index(Model model, @Param("keyword") String keyword) {
        List<Cargo> cargoList = service.getAllCargos(keyword);
        model.addAttribute("cargoList", cargoList);
        model.addAttribute("keyword", keyword);
        return "index";
    }

    /**
     * Отображает форму для создания нового груза.
     * @param model модель для хранения атрибутов для представления
     * @return имя представления, которое будет отображено
     */
    @RequestMapping("/new")
    public String newCargo(Model model) {
        model.addAttribute("cargo", new Cargo());
        return "new";
    }

    /**
     * Сохраняет новую запись о грузе
     * @param cargo груз, который нужно сохранить
     * @return редирект на главную страницу
     */
    @PostMapping("/save")
    public String saveCargo(@ModelAttribute("cargo") Cargo cargo) {
        service.saveCargo(cargo);
        return "redirect:/";
    }

    /**
     * Отображает форму для редактирования нового груза
     * @param id идентификатор груза, который нужно редактировать
     * @return объект ModelAndView, содержащий имя представления и объект груза
     */
    @GetMapping("/edit/{id}")
    public ModelAndView editCargo(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("edit");
        Cargo cargo = service.getCargo(id);
        mav.addObject("cargo", cargo);
        return mav;
    }

    /**
     * Удаляет запись о грузе.
     * @param id идентификатор груза, который нужно удалить
     * @return редирект на главную страницу
     */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.deleteCargo(id);
        return "redirect:/";
    }
}