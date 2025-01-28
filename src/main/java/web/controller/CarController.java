package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDao;
import web.models.Car;
import web.service.CarService;

import java.util.List;

@Controller
public class CarController {

    final
    CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/car")
    public String getCars(@RequestParam(value = "count", required = false) Integer count, Model model) {
        List<Car> listCar = carService.getCars(count);
        model.addAttribute("cars", listCar);
        return "car/car";
    }
}
