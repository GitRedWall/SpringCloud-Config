package com.ilabservice.intelab.repository;

import com.ilabservice.intelab.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface RoleRepository extends CrudRepository<Role, Long>{

    Role findByName(String name);

    List<Role> findAll();

}
