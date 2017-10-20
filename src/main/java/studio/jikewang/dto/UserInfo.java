package studio.jikewang.dto;

/**
 * @author 李文浩
 * @version 2017/10/19.
 */
public class UserInfo {
    private int id;
    private Integer companyId;
    private String userId;
    private String position;
    private Double score;
    String companyName;
    Integer number;
    Integer isScored;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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
