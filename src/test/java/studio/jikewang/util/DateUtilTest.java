package studio.jikewang.util;

import org.junit.Test;
import studio.jikewang.entity.Application;
import studio.jikewang.exception.ErrorException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 李文浩
 * @version 2017/10/17.
 */
public class DateUtilTest {
    @Test
    public void test() throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Application application = new Application();
        application.setModifiedTime(new Date());
        application.setCalculatedGrade(2);
        Date now = new Date();
        Date startTime = new Date(application.getModifiedTime().getTime() + 10 * 60 * 1000 * (application.getCalculatedGrade() - 1));
        Date failureTime = new Date(application.getModifiedTime().getTime() + 10 * 60 * 1000 * application.getCalculatedGrade());
        System.out.println(df.format(startTime));
        System.out.println(df.format(failureTime));

        System.out.println(startTime.after(now));
        System.out.println(now.after(failureTime));
        System.out.println(DateUtil.isCanAcceptApplication(now, startTime));
        System.out.println(DateUtil.isCanAcceptApplication(now, failureTime));
        ;
        if (startTime.after(now) &&
                now.after(failureTime)) {
            throw new ErrorException("现在你没有权限接受这个学生的申请，请在" + df.format(failureTime) + "再来尝试，或者等待" + application.getUserId() + "被其他公司拒绝");
        } else {
            System.out.println("dd");
        }

    }
}
