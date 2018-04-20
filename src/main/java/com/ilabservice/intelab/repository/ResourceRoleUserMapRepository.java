package com.ilabservice.intelab.repository;

import com.ilabservice.intelab.model.ResourceRoleUserMap;
import com.ilabservice.intelab.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResourceRoleUserMapRepository extends CrudRepository<ResourceRoleUserMap, Long> {

    List<ResourceRoleUserMap> findByResourceIdAndUserId(long resourceId, long userId);

}
