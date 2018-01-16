package studio.jikewang.dto;

import org.hibernate.validator.constraints.Range;
import studio.jikewang.util.Update;

import java.io.Serializable;

/**
 * @author 李文浩
 * @version 2017/10/9.
 */
public class StudentClass implements Serializable{
    private int id;
    private String userId;
    private String cls;
    private String discipline;
    private String grade;
    private String userName;
    private String classId;
    private String type;
    private String companyName;
    private String position;
    private Double score;
    @Range(min = 0, max = 100, message = "你的分数打错了吧", groups = Update.class)
    private Double teacherScore;
    private Double companyScore;
    private Double studentScore;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getTeacherScore() {
        return teacherScore;
    }

    public void setTeacherScore(Double teacherScore) {
        this.teacherScore = teacherScore;
    }

    public Double getCompanyScore() {
        return companyScore;
    }

    public void setCompanyScore(Double companyScore) {
        this.companyScore = companyScore;
    }

    public Double getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(Double studentScore) {
        this.studentScore = studentScore;
    }

    @Override
    public String toString() {
        return "StudentClass{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", cls='" + cls + '\'' +
                ", discipline='" + discipline + '\'' +
                ", grade='" + grade + '\'' +
                ", userName='" + userName + '\'' +
                ", classId='" + classId + '\'' +
                ", type='" + type + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", score=" + score +
                ", teacherScore=" + teacherScore +
                ", companyScore=" + companyScore +
                ", studentScore=" + studentScore +
                '}';
    }
}
