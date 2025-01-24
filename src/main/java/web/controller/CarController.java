package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDao;
import web.models.Car;

import java.util.List;

@Controller
public class CarController {

    final CarDao carDao;

    @Autowired
    public CarController(CarDao carDao) {
        this.carDao = carDao;
    }

    @GetMapping(value = "/car")
    public String car(@RequestParam(value = "count", required = false) Integer count, Model model) {
        List<Car> listCar = carDao.getCars(count);
        model.addAttribute("cars", listCar);
        return "car/car";
    }
}
