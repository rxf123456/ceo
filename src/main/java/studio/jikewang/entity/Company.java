package studio.jikewang.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import studio.jikewang.util.Insert;
import studio.jikewang.util.Update;

/**
 * @author 李文浩
 * @version 2017/10/2.
 */
public class Company {
    int id;

    @NotEmpty(message = "公司名不为空", groups = Insert.class)
    String name;

    @Range(min = 1 , max = 7, message = "人数出现问题",groups = {Update.class})
    int number;

    @Range(min = 0, max = 100, message = "你的分数打错了吧", groups = Update.class)
    int score;

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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
