package com.github.zyt.elasticsearch.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * @Author: zyt
 * @Date: 2019/7/16
 * @Description:
 */
@Document(indexName = "blogs", type = "blog", shards = 3, replicas = 2)
public class Blog {

    @Id
    private String key;
    @Field
    private String title;
    @Field
    private String content;

    public Blog() {
    }

    public Blog(String key, String title, String content) {
        this.key = key;
        this.title = title;
        this.content = content;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "key='" + key + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
