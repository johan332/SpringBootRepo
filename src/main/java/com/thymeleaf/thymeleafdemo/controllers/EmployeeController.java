package com.thymeleaf.thymeleafdemo.controllers;

import com.thymeleaf.thymeleafdemo.models.Employee;
import com.thymeleaf.thymeleafdemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/getAll")
    public String getAll(Model model)
    {
        List<Employee> employees=employeeService.getAll();
        model.addAttribute("employees", employees);

        String username="Johan";
        model.addAttribute("username", username);

        return "employees";
    }

    @RequestMapping("/getOne")
    @ResponseBody
    public Optional<Employee> getOne(Integer Id)
    {
        return employeeService.getOne(Id);
    }

    @PostMapping("/addNew")
    public String addNew(Employee employee)
    {
        employeeService.addNew(employee);
        return "redirect:/employees/getAll";
    }

    @RequestMapping(value = "/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Employee employee)
    {
        employeeService.update(employee);
        return "redirect:/employees/getAll";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    public String deleteEmployee(Integer Id)
    {
        employeeService.delete(Id);
        return "redirect:/employees/getAll";
    }

}
