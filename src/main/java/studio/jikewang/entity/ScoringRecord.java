package studio.jikewang.entity;

/**
 * @author 李文浩
 * @version 2017/11/13.
 */
public class ScoringRecord {
    private int id;
    private String scoredUserId;
    private String userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScoredUserId() {
        return scoredUserId;
    }

    public void setScoredUserId(String scoredUserId) {
        this.scoredUserId = scoredUserId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
