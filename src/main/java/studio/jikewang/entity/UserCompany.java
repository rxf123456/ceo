package studio.jikewang.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import studio.jikewang.util.Insert;
import studio.jikewang.util.Update;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author 李文浩
 * @version 2017/10/9.
 */
public class UserCompany implements Serializable {
    private int id;
    @NotNull(message = "公司号不为空", groups = Insert.class)
    private Integer companyId;
    @NotEmpty(message = "学号不为空", groups = Insert.class)
    private String userId;
    private String position;
    @Range(min = 0, max = 100, message = "你的分数打错了吧", groups = Update.class)
    private Double score;
    private Integer scored;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public Integer getScored() {
        return scored;
    }

    public void setScored(Integer scored) {
        this.scored = scored;
    }

    @Override
    public String toString() {
        return "UserCompany{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", userId='" + userId + '\'' +
                ", position='" + position + '\'' +
                ", score=" + score +
                ", scored=" + scored +
                '}';
    }
}

