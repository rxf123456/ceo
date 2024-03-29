package studio.jikewang.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import java.util.Date;

/**
 * @author 李文浩
 * @version 2017/10/19.
 */
public class Application {
    private int id;
    @NotEmpty(message = "学号不为空")
    private String userId;
    @Range(message = "公司号为数字",min = 1)
    private Integer companyId;

    //    @Future(message = "你的时间错了吧")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    //    @Future(message = "你的时间错了吧")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date modifiedTime;
    @Range(min = 1, max = 6, message = "志愿级别出现问题")
    private int grade;
    private int calculatedGrade;

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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getCalculatedGrade() {
        return calculatedGrade;
    }

    public void setCalculatedGrade(int calculatedGrade) {
        this.calculatedGrade = calculatedGrade;
    }
}
