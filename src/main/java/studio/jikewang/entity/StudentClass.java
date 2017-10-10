package studio.jikewang.entity;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author 李文浩
 * @version 2017/10/9.
 */
public class StudentClass {

    private int id;
    private String classId;

    private String userId;

    @NotEmpty(message = "CEO职位不为空")
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "StudentClass{" +
                "id=" + id +
                ", classId='" + classId + '\'' +
                ", userId='" + userId + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
