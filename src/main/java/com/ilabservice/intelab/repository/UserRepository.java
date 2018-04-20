package com.ilabservice.intelab.repository;

import com.ilabservice.intelab.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface UserRepository extends CrudRepository<User, Long> {
    public User findTopByName(String name);

    public User findByUserName(String userName);

    public List<User> findByCompanyId(Long companyId);

    @Query("select u from User u where u.company.id is ?1")
    public List<User> findByAndSort(Long companyId, Sort sort);

    // 查询所在公司的所有用户。pageable可以设定页码，页容量以及排序方式。
    public Page<User> findByCompanyId(Long companyId, Pageable pageable);

    public User findById(Long id);
}