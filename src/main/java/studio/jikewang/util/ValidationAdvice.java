package studio.jikewang.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

/**
 * @author 李文浩
 * @version 2017/10/8.
 */
public class ValidationAdvice {

    /**
     *
     * 切点处理
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
        Errors result = null;
        Object[] args = pjp.getArgs();
        if (args != null && args.length != 0) {
            for (Object object : args) {
                if (object instanceof BindingResult) {
                    result = (BindingResult) object;
                    break;
                }
            }
        }
        if (result != null && result.hasErrors()) {
            return ResultUtil.messageResult(result);
        }
        return pjp.proceed();
    }

}
