package task2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import task2.repositories.EmployeeRepository;

@Controller
public class EmployeesController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping({"/", "/employees"})
    public String getEmployeesPage(ModelMap model) {
        model.addAttribute("employeesFromServer", employeeRepository.findAll());
        return "employees";
    }

}
