package studio.jikewang.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import studio.jikewang.util.Insert;
import studio.jikewang.util.Update;

import java.io.Serializable;

/**
 * @author 李文浩
 * @version 2017/10/2.
 */
public class Company implements Serializable {
    public final static int MAX_NUMBER = 7;
    /**
     * 在这个公司的每个班的最多人数,防止一个寝室的都选一个公司
     */
    public final static int CLASS_NUM = 3;

    public final static String CEO = "CEO";
    int id;
    @NotEmpty(message = "公司名不为空", groups = Insert.class)
    String name;
    @Range(min = 1, max = 7, message = "人数出现问题")
    Integer number;
    @Range(min = 0, max = 100, message = "你的分数打错了吧", groups = Update.class)
    Double score;
    Integer isScored;

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


    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getIsScored() {
        return isScored;
    }

    public void setIsScored(Integer isScored) {
        this.isScored = isScored;
    }
}

