package com.example.SpringBootApp.service;

import com.example.SpringBootApp.dao.EmployeeDAO;
import org.springframework.stereotype.Service;
import com.example.SpringBootApp.entity.Employee;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> getEmployees() {
        return employeeDAO.getEmployees();
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    @Transactional
    public void addEmployee(Employee employee) {

        employee.setId(null);
        employeeDAO.addEmployee(employee);

    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.getEmployeeById(id);
        employeeDAO.deleteEmployee(id);
    }
}
