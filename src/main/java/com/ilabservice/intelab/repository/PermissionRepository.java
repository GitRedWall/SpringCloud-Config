package com.ilabservice.intelab.repository;

import com.ilabservice.intelab.model.Permission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface PermissionRepository extends CrudRepository<Permission, Long>{

    Permission findByName(String name);

}
