package studio.jikewang.dto;

import studio.jikewang.entity.Application;

/**
 * @author 李文浩
 * @version 2017/10/20.
 */
public class UserApplication {
    private Application application;
    String companyName;
    Integer number;

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
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
}
