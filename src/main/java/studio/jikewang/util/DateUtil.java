package studio.jikewang.util;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 李文浩
 * @version 2017/4/22.
 */
public class DateUtil {
    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public static boolean notDeadline(Date now, Date date) {
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

    @Test
    public void test() throws ParseException {
        System.out.println(notDeadline(df.parse("2017-4-22"), df.parse("2017-4-23")));
    }
}
