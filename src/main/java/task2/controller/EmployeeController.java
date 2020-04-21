package task2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import task2.forms.EmployeeForm;
import task2.models.Employee;
import task2.repositories.EmployeeRepository;

import java.util.Optional;

import static task2.forms.EmployeeForm.formToEmployee;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;


    @GetMapping("/addemployee")
    public String getAddEmployeesPage() {
        return "addEmployee";
    }

    @PostMapping("/addemployee")
    public String setNewEmployee(EmployeeForm employeeForm) {
        employeeRepository.save(formToEmployee(employeeForm));
        return "redirect:/employees";
    }

    @GetMapping("/deleteemployee")
    public String getDeleteEmployees(@RequestParam Integer employee_id) {
        employeeRepository.deleteById(employee_id);
        return "redirect:/employees";
    }

    @GetMapping("/editemployee")
    public String getEditEmployeesPage(ModelMap model, @RequestParam Integer employee_id) {
        if (employee_id != null) {
            Optional<Employee> employee = employeeRepository.findById(employee_id);
            if (employee.isPresent()) {
                model.addAttribute("employee", employee.get());
                return "editEmployee";
            }
        }
        return "redirect:/employees";
    }

    @PostMapping("/editemployee")
    public String setEditEmployee(EmployeeForm employeeForm, @RequestParam Integer employee_id) {
        Optional<Employee> employee = employeeRepository.findById(employee_id);
        if (employee.isPresent()) {
            employee.get().setName(employeeForm.getName());
            employee.get().setJob(employeeForm.getJob());
            employee.get().setHireDate(employeeForm.getHireDate());
            employee.get().setSalary(employeeForm.getSalary());
            employeeRepository.save(employee.get());
        }
        return "redirect:/employees";
    }

}
