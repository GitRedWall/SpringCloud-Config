package com.ilabservice.intelab.repository;

import com.ilabservice.intelab.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CompanyRepository extends CrudRepository<Company, Long> {
    Company findTopBySysCodeOrderById(String SysCode);
}