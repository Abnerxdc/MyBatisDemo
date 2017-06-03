package com.xdc.mybatis.bean;


/**
 * Created by Administrator on 2017/6/3.
 */
public class Teacher {

    //定义实体类的属性，与teacher表中的字段对应
    private int id;            //id===>teacher_id
    private String name;    //name===>teacher_name

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher [id=" + id + ", name=" + name + "]";
    }
}
