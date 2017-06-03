package com.xdc.mybatis.bean;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Administrator on 2017/6/3.
 */
public class Classes {
    private static Logger logger = Logger.getLogger(Classes.class);

    //定义实体类的属性，与class表中的字段对应
    private int id;            //id===>c_id
    private String name;    //name===>c_name

    /**
     * class表中有一个teacher_id字段，所以在Classes类中定义一个teacher属性，
     * 用于维护teacher和class之间的一对一关系，通过这个teacher属性就可以知道这个班级是由哪个老师负责的
     */
    private Teacher teacher;
    //使用一个List<Student>集合属性表示班级拥有的学生
     private List<Student> students;

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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        logger.debug("debugList:"+students);
        return "Classes [id=" + id + ", name=" + name + ", teacher=" + teacher + ", students=" + students + "]";
    }
    public JSONArray toJSONArray(){
        JSONArray jsonArray = new JSONArray();
        for (Student st : students){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("c.id",id);
            jsonObject.put("c.name",name);
            jsonObject.put("s.id",st.getId());
            jsonObject.put("s.name",st.getName());
            jsonObject.put("t.id",teacher.getId());
            jsonObject.put("t.name",teacher.getName());
            jsonArray.add(jsonObject);
        }

        return jsonArray;
    }
}
