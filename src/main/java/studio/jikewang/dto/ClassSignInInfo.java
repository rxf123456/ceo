package studio.jikewang.dto;

import java.util.Date;

/**
 * @author 袁阳
 * @version 2017/4/22.
 * 教师查看班级的签到信息
 */
public class ClassSignInInfo {

    private String signInId;    //签到编号
    private String signInCode;  //签到码
    private Date time;  //签到发起时间
    private int isClose; //签到是否关闭
    private int signInSuccess;  //成功签到人数
    private int signInFail; //未签到人数

    public String getSignInId() {
        return signInId;
    }

    public void setSignInId(String signInId) {
        this.signInId = signInId;
    }

    public String getSignInCode() {
        return signInCode;
    }

    public void setSignInCode(String signInCode) {
        this.signInCode = signInCode;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getIsClose() {
        return isClose;
    }

    public void setIsClose(int isClose) {
        this.isClose = isClose;
    }

    public int getSignInSuccess() {
        return signInSuccess;
    }

    public void setSignInSuccess(int signInSuccess) {
        this.signInSuccess = signInSuccess;
    }

    public int getSignInFail() {
        return signInFail;
    }

    public void setSignInFail(int signInFail) {
        this.signInFail = signInFail;
    }

    @Override
    public String toString() {
        return "ClassSignInInfo{" +
                "signInId='" + signInId + '\'' +
                ", signInCode='" + signInCode + '\'' +
                ", time=" + time +
                ", isClose=" + isClose +
                ", signInSuccess=" + signInSuccess +
                ", signInFail=" + signInFail +
                '}';
    }
}
