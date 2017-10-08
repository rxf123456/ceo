package studio.jikewang.exception;

import org.apache.ibatis.binding.BindingException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import studio.jikewang.util.Result;
import studio.jikewang.util.ResultUtil;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * @author 李文浩
 * @version 2017/2/15.
 */

@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(ErrorException.class)
    public Result handleErrorException(ErrorException e) {
        Result result = new Result();
        result.setStatus("0");
        result.setMessage(e.getError());
        return result;
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public Result handleException(DuplicateKeyException e) {
        Result result = new Result();
        result.setStatus("0");
        result.setMessage("参数在数据库中已有值");
        return result;
    }

    @ExceptionHandler(NullPointerException.class)
    public Result handleNullPointerException(NullPointerException e) {
        Result result = new Result();
        result.setStatus("0");
        result.setMessage("你传值了吗？没收到啊");
        return result;
    }

    @ExceptionHandler(NumberFormatException.class)
    public Result handleNumberFormatException(NumberFormatException e) {
        Result result = new Result();
        result.setStatus("0");
        result.setMessage("你传的不是数字吧");
        return result;

    }

    @ExceptionHandler(BindingException.class)
    public Result handleBindingException(BindingException e) {
        Result result = new Result();
        result.setStatus("0");
        result.setMessage("数据库绑定异常");
        return result;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public Result handleConstraintViolationException(ConstraintViolationException e) {
        for (ConstraintViolation<?> s : e.getConstraintViolations()) {
            System.out.println(s.getInvalidValue() + ": " + s.getMessage());
        }
        Result result = new Result();
        result.setStatus("0");
        result.setMessage("数据验证失败");
        return result;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public Result handleException(Exception e) {
        e.printStackTrace();
        return ResultUtil.UNHANDED_RESULT;
    }


}

