package com.market.entity;

/**
 * @author 冯健芸
 * @create 2018-01-02 14:24
 *
 * @name
 */
public class Role {

    private Integer id;

    private String name;

    private String funs;

    public String getFuns() {
        return funs;
    }

    public void setFuns(String funs) {
        this.funs = funs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
