package studio.jikewang.dto;

/**
 * @author 袁阳
 * @version 2017/4/18.
 * 学生获取教学班级信息,只作为返回信息使用
 */
public class StudentCourseInfo {

    private String studentId;
    private String classId;
    private String className;
    private int credit;
    private int classPeriod;
    private String term;
    private int score;

    @Override
    public String toString() {
        return "StudentCourseInfo{" +
                "studentId='" + studentId + '\'' +
                ", classId='" + classId + '\'' +
                ", className='" + className + '\'' +
                ", credit=" + credit +
                ", classPeriod=" + classPeriod +
                ", term='" + term + '\'' +
                ", score=" + score +
                '}';
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getClassPeriod() {
        return classPeriod;
    }

    public void setClassPeriod(int classPeriod) {
        this.classPeriod = classPeriod;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

}
