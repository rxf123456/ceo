package studio.jikewang.util;

/**
 * @author 李文浩
 * @version 2017/4/15.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {

    /**
     * 空值验证
     *
     * @param value
     * @return
     */
    public static boolean notNull(Object value) {
        return value != null;
    }

    /**
     * 字符串非空验证
     *
     * @param value
     * @return
     */
    public static boolean notEmpty(String value) {
        return value != null && !"".equals(value);
    }

    /**
     * 字符串空验证
     *
     * @param value
     * @return
     */
    public static boolean isEmpty(String value) {
        return value == null || "".equals(value);
    }

    /**
     * 正则表达式验证
     *
     * @param regex
     * @param value
     * @return true 为成功, false 为失败
     */
    public static boolean matches(String regex, String value) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(value);
        return m.find();
    }

    public static void main(String[] args) {
        System.out.println(ValidateUtil.matches("^\\d+$","1"));
    }
}