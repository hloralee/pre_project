package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDAO;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    private CarDAO carDAO;

    @Autowired
    public CarController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping("/cars")
    public String printAllCar(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        if (count == null) {
            model.addAttribute("cars", carDAO.show(carDAO.getCars().size()));
        } else {
            model.addAttribute("cars", carDAO.show(count));
        }
        return "/cars";
    }
}
