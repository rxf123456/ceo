package studio.jikewang.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李文浩
 * @version 2017/10/8.
 */
public class ValidationAdvice {

    /**
     * 切点处理
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        boolean isValidList = false;
        Errors errors = null;
        if (null != args && args.length != 0) {
            for (Object object : args) {
                if (object instanceof ValidList) {
                    isValidList = true;
                }
                if (object instanceof BindingResult) {
                    errors = (BindingResult) object;
                    break;
                }
            }
        }
        if (errors != null && errors.hasErrors()) {
            List<ObjectError> allErrors = errors.getAllErrors();
            List<String> messages = new ArrayList<String>();
            for (ObjectError error : allErrors) {
                if (isValidList) {
                    messages.add(error.getDefaultMessage());
                    break;
                } else {
                    messages.add(error.getDefaultMessage());
                }
            }
            return ResultUtil.messageResult(messages);
        }
        return pjp.proceed();
    }
}
