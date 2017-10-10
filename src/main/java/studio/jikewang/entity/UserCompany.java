package studio.jikewang.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import studio.jikewang.util.Insert;
import studio.jikewang.util.Update;

/**
 * @author 李文浩
 * @version 2017/10/9.
 */
public class UserCompany {

    private int id;
    @NotEmpty(message = "公司号不为空", groups = Insert.class)
    private Integer companyId;
    @NotEmpty(message = "学号不为空", groups = Insert.class)
    private String userId;

    @NotEmpty(message = "职位不为空", groups = Update.class)
    private String position;
    @Range(min = 0, max = 100, message = "你的分数打错了吧", groups = Update.class)
    private int score_ceo;
    @Range(min = 0, max = 100, message = "你的分数打错了吧", groups = Update.class)
    private int score_user;

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

    public int getScore_ceo() {
        return score_ceo;
    }

    public void setScore_ceo(int score_ceo) {
        this.score_ceo = score_ceo;
    }

    public int getScore_user() {
        return score_user;
    }

    public void setScore_user(int score_user) {
        this.score_user = score_user;
    }
}
