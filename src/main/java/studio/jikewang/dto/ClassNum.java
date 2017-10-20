package studio.jikewang.dto;

import java.io.Serializable;

/**
 * @author 李文浩
 * @version 2017/10/18.
 */
public class ClassNum implements Serializable {
    private String cls;
    private Integer num;

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "ClassNum{" +
                "cls='" + cls + '\'' +
                ", num=" + num +
                '}';
    }
}
