package com.lukaCode.springboot.cruddemo.rest;

import com.lukaCode.springboot.cruddemo.dao.EmployeeDAO;
import com.lukaCode.springboot.cruddemo.entity.Employee;
import com.lukaCode.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
   private EmployeeService employeeService;

   @Autowired
   public EmployeeRestController(EmployeeService employeeService){
       this.employeeService=employeeService;
   }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{empId}")
    public Employee findById(@PathVariable int empId){ //Ak ar dagvaviwydes @PathVariable anotacia (es sul gaviwydeba da gvawvalebs)
       Employee employee=employeeService.findById(empId);
       if(employee==null){
           throw new RuntimeException("Employee id not found!"+empId);
       }


       return employee;
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee){
       employee.setId(0); //yoveli shemtxvevistvis tu id mainc gamoayoles gavanulot
       return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee){
       return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{empId}")
    public String delete(@PathVariable int empId){
       Employee employee=employeeService.findById(empId);
       if(employee==null){
           throw new RuntimeException("Employee id not found - "+empId);
       }
       employeeService.deleteById(empId);

       return  "Deleted employee: "+employee;
    }
}