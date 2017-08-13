package io.egen.service;

import io.egen.entity.Employee;
import io.egen.exception.BadRequestException;
import io.egen.exception.ResourceNotFoundException;
import io.egen.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository repository;

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public Employee findOne(String id) {
        Employee existing = repository.findOne(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Employee with id " + id + " doesn't exist.");
        }
        return existing;
    }

    public Employee create(Employee emp) {
        Employee existing = repository.findByEmail(emp.getEmail());
        if (existing != null) {
            throw new BadRequestException("Employee with email " + emp.getEmail() + " already exists.");
        }
        return repository.create(emp);
    }

    public Employee update(String id, Employee emp) {
        Employee existing = repository.findOne(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Employee with id " + id + " doesn't exist.");
        }
        return repository.update(emp);
    }

    public void delete(String id) {
        Employee existing = repository.findOne(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Employee with id " + id + " doesn't exist.");
        }
        repository.delete(existing);
    }
}