package com.microservice.department_service.controller;


import com.microservice.department_service.client.EmployeeClient;
import com.microservice.department_service.model.Department;
import com.microservice.department_service.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping
    public Department add(@RequestBody Department department){
        LOGGER.info("Department add{}",department);
        return departmentRepository.add(department);
    }

    @GetMapping
    public List<Department> findAll(){
        LOGGER.info("findALL");
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id){
        LOGGER.info("id {}",id);
        return departmentRepository.findById(id);
    }


    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees(){
        LOGGER.info("findAllWithEmployees");
        List<Department> departments = departmentRepository.findAll();
        departments.forEach(department -> department.setEmployees(employeeClient.findBydId(department.getId())));
    return departments;
    }

}
