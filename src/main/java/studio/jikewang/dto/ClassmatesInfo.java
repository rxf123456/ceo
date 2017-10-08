package studio.jikewang.dto;

/**
 * @author 袁阳
 * @version 2017/4/18.
 * 用于教师查看班级中学生情况的实体类
 */
public class ClassmatesInfo {

    private String studentId;
    private String studentName;
    private int score;
    private String sex;
    private String country;

    @Override
    public String toString() {
        return "ClassmatesInfo{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", score=" + score +
                ", sex='" + sex + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
