package io.zipcoder.persistenceapp.services;
import io.zipcoder.persistenceapp.models.Department;
import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.repository.DepartmentRepository;
import io.zipcoder.persistenceapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private EmployeeService employeeService;

    public Department create(Department department){
        return repository.save(department);
    }

    public Department update(Long id, Department department){
        Department ogDepartment = findOne(id);
        ogDepartment.setDepartmentName(department.getDepartmentName());
        ogDepartment.setManager(department.getManager());

        return repository.save(ogDepartment);
    }

    public Department findOne(Long id){
        return repository.findByDepartmentId(id);
    }

    public Iterable<Department> findAll(){
        return repository.findAll();
    }

    public Boolean delete(Long id){
        repository.delete(id);
        return true;
    }

    public Department setManager(Long id, Long managerId){
        Department department = findOne(id);
        Employee manager = employeeService.findOne(managerId);
        if (department != null && manager != null) {
            department.setManager(manager);
            manager.setDepartmentId(id);
            employeeService.update(managerId, manager);
            return repository.save(department);
        } else {
            return null;
        }
    }
}
