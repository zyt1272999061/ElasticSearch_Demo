package com.github.zyt.elasticsearch.controller;

import com.alibaba.fastjson.JSON;
import com.github.zyt.elasticsearch.dao.BlogRepository;
import com.github.zyt.elasticsearch.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.Set;

/**
 * @Author: zyt
 * @Date: 2019/7/16
 * @Description:
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/add")
    public String addRedis2ES() {
        Set<String> s = stringRedisTemplate.keys("*");
        Iterator it = s.iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            String blogStr = stringRedisTemplate.opsForValue().get(key);
            Blog blog = JSON.parseObject(blogStr, Blog.class);
            //System.out.println(blog.toString());
            blogRepository.save(blog);
        }
        return "success";
    }
}
