package com.github.zyt.elasticsearch.dao;


import com.github.zyt.elasticsearch.entity.Blog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author: zyt
 * @Date: 2019/7/16
 * @Description:
 */
public interface BlogRepository extends ElasticsearchRepository<Blog, String> {

}
