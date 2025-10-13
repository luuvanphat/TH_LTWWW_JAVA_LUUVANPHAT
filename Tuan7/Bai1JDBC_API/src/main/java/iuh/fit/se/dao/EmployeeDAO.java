package iuh.fit.se.dao;

import iuh.fit.se.entities.Employee;

import java.util.List;

public interface EmployeeDAO {
    void save(Employee emp);
    void update(Employee emp);
    void deleteById(int id);
    Employee getById(int id);
    List<Employee> getAll();
}

