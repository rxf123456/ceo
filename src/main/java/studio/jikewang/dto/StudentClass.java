package studio.jikewang.dto;

import java.io.Serializable;

/**
 * @author 李文浩
 * @version 2017/10/9.
 */
public class StudentClass implements Serializable{
    private static final long serialVersionUID = -6849794470754667710L;
    private int id;
    private String classId;
    private String userId;
    private String userName;
    private String cls;
    private String type;
    private int score;
    private int teacherScore;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTeacherScore() {
        return teacherScore;
    }

    public void setTeacherScore(int teacherScore) {
        this.teacherScore = teacherScore;
    }

    @Override
    public String toString() {
        return "StudentClass{" +
                "id=" + id +
                ", classId='" + classId + '\'' +
                ", userId='" + userId + '\'' +
                ", type='" + type + '\'' +
                ", score=" + score +
                ", teacherScore=" + teacherScore +
                '}';
    }
}
