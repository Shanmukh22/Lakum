package io.egen.repository;

import io.egen.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    public List<Employee> findAll() {
        Employee e1 = new Employee();
        e1.setEmail("psalitra@egen.io");
        e1.setFirstName("Praveen");
        e1.setLastName("Salitra");

        Employee e2 = new Employee();
        e2.setEmail("jsmith@egen.io");
        e2.setFirstName("Jake");
        e2.setLastName("Smith");

        return Arrays.asList(e1, e2);
    }

    public Employee findOne(String id) {
        Employee e1 = new Employee();
        e1.setEmail("psalitra@egen.io");
        e1.setFirstName("Praveen");
        e1.setLastName("Salitra");
        return e1;
    }

    public Employee findByEmail(String email) {
        return null;
    }

    public Employee create(Employee emp) {
        return null;
    }

    public Employee update(Employee emp) {
        return null;
    }

    public void delete(Employee emp) {

    }
}
