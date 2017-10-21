package studio.jikewang.util;

import java.util.Date;

/**
 * @author 李文浩
 * @version 2017/4/22.
 */
public class DateUtil {
    public static boolean isCanAcceptApplication(Date now, Date date) {
        if (now.compareTo(date) == 0) {
            return true;
        }
        if (now.compareTo(date) < 0) {
            return true;
        }
        if (now.compareTo(date) > 0) {
            return false;
        }
        return false;
    }


}
