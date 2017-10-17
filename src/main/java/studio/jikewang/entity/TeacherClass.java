package studio.jikewang.entity;

import java.io.Serializable;

/**
 * @author 李文浩
 * @version 2017/10/10.
 */
public class TeacherClass implements Serializable {
    int id;
    String teacherId;
    String classId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }
}
