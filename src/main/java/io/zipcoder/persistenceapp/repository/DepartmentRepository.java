package io.zipcoder.persistenceapp.repository;

import io.zipcoder.persistenceapp.models.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {

    Department findByDepartmentId(Long id);
}
