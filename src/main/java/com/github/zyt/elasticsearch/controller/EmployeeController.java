package com.github.zyt.elasticsearch.controller;

import com.github.zyt.elasticsearch.dao.EmployeeRepository;
import com.github.zyt.elasticsearch.entity.Employee;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zyt
 * @Date: 2019/2/21 17:48
 * @Description:
 */
@RestController
@RequestMapping("es")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * 添加
     *
     * @return
     */
    @RequestMapping("add")
    public String add() {
        Employee employee = new Employee("1","xx","zh",26,"i am in peking");
        employeeRepository.save(employee);
        System.err.println("add a obj");
        return "success";
    }

    /**
     * 删除
     *
     * @return
     */
    @RequestMapping("delete")
    public String delete() {
        Employee employee = employeeRepository.queryEmployeeById("1");
        employeeRepository.delete(employee);
        return "success";
    }

    /**
     * 局部更新
     *
     * @return
     */
    @RequestMapping("update")
    public String update() {
        Employee employee = employeeRepository.queryEmployeeById("1");
        employee.setFirstName("哈哈");
        employeeRepository.save(employee);
        System.err.println("update a obj");
        return "success";
    }

    /**
     * 查询
     *
     * @return
     */
    @RequestMapping("query")
    public Employee query() {
        Employee accountInfo = employeeRepository.queryEmployeeById("1");
        System.err.println(new Gson().toJson(accountInfo));
        return accountInfo;
    }


}
