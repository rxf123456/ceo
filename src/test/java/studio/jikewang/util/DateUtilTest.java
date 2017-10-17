package studio.jikewang.util;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author 李文浩
 * @version 2017/10/17.
 */
public class DateUtilTest {
    @Test
    public void test() throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(DateUtil.notDeadline(df.parse("2017-4-22"), df.parse("2017-4-23")));
    }
}
