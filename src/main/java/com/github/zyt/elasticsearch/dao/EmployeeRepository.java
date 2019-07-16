package com.github.zyt.elasticsearch.dao;

import com.github.zyt.elasticsearch.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @Author: zyt
 * @Date: 2019/2/21 17:46
 * @Description:
 */
@Component
public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {

    Employee queryEmployeeById(String id);
}
