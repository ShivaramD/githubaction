package com.microservice.department_service.repository;

import com.microservice.department_service.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {

    List<Department> departments = new ArrayList<>();

    public  Department add(Department department){
        departments.add(department);
        return department;
    }

    public  Department findById(Long id){
         return departments.stream().filter(department -> department.getId().equals(id))
                 .findFirst()
                 .orElseThrow();
    }

    public  List<Department> findAll(){
        return departments;
    }



}
