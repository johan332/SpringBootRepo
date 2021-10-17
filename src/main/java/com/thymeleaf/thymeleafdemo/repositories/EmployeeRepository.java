package com.thymeleaf.thymeleafdemo.repositories;

import com.thymeleaf.thymeleafdemo.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository <Employee, Integer>
{
}
