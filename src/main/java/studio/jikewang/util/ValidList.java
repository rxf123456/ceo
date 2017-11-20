package studio.jikewang.util;

import javax.validation.Valid;
import java.util.*;

/**
 * @author 李文浩
 * @version 2017/11/20.
 */
public class ValidList<E> {

    @Valid
    private List<E> list;

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }
}
