package pe.edu.i202030205.alejandro_brenda.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.i202030205.alejandro_brenda.dto.CarDto;
import pe.edu.i202030205.alejandro_brenda.service.ManageService;

import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    ManageService manageService;

    @GetMapping("/start")
    public String start(Model model) {

        try {
            List<CarDto> users = manageService.getAllCars();
            model.addAttribute("cars", users);
            model.addAttribute("error", null);

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("ERROR!!!",  "Ocurrió un error al obtener los datos.");
        }
        return "Home";
    }
}
