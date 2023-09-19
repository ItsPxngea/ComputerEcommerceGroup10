package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;
import za.ac.cput.repository.EmployeeRepository;
import za.ac.cput.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;

    @Autowired
    private EmployeeServiceImpl(EmployeeRepository repository){
        this.repository = repository;
    }

    @Override
    public Employee create(Employee employee) {
        return this.repository.save(employee);
    }

    @Override
    public Employee read(Long customerID) {
        return this.repository.findById(customerID).orElse(null);
    }

    @Override
    public Employee update(Employee employee) {
        if(this.repository.existsById((employee.getEmployeeID())))
            return this.repository.save(employee);
        return null;
    }

    @Override
    public boolean delete(Long customerID) {
        if (this.repository.existsById(customerID)){
            this.repository.deleteById(customerID);
            return  true;
        }
        return false;
    }

    @Override
    public List<Employee> getAll() {
        return this.repository.findAll();
    }

    public Employee authenticate(String email, String password) {
        Employee employee = repository.findByEmail(email);

        if (employee != null && employee.getPassword().equals(password)) {
            return employee;
        }

        return null;
    }
}
