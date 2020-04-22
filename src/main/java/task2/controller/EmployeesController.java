package task2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import task2.repositories.EmployeeRepository;
import task2.services.LoadFromFileService;

@Controller
public class EmployeesController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private LoadFromFileService loadFromFileService;

    @GetMapping({"/", "/employees"})
    public String getEmployeesPage(ModelMap model) {
        model.addAttribute("employeesFromServer", employeeRepository.findAll());
        return "employees";
    }
    @PostMapping("/loadFromFile")
    public String addFromFile(@RequestParam("file")MultipartFile file){
        loadFromFileService.loadFromFile(file);
        return "redirect:/employees";
    }


}
