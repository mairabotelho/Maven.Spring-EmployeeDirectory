package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee create(Employee employee){
        return repository.save(employee);
    }

    public Employee update(Long id, Employee employee){
        Employee ogEmplyee = findOne(id);
        ogEmplyee.setFirstName(employee.getFirstName());
        ogEmplyee.setLastName(employee.getLastName());
        ogEmplyee.setTitle(employee.getTitle());
        ogEmplyee.setPhoneNumber(employee.getPhoneNumber());
        ogEmplyee.setEmail(employee.getEmail());
        ogEmplyee.setHireDate(employee.getHireDate());
        ogEmplyee.setManager(employee.getManager());
        ogEmplyee.setDepartmentId(employee.getDepartmentId());

        return repository.save(ogEmplyee);
    }

    public Employee findOne(Long id){
        return repository.findOne(id);
    }

    public Iterable<Employee> findAll(){
        return repository.findAll();
    }

    public Boolean delete(Long id){
        repository.delete(id);
        return true;
    }

}
