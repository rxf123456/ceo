package studio.jikewang.util;


import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

public class ResultUtil {

    public static final Result SUCCESS_RESULT = new Result("1", "success", null);
    public static final Result FAIL_RESULT = new Result("0", "fail", null);
    public static final Result UNHANDED_RESULT = new Result("0", "未处理异常", null);
    public static final Result NOT_FOUND_RESULT = new Result("0", "404", null);

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    public static Result successResult(Object o) {
        Result result = new Result();
        result.setStatus("1");
        result.setMessage(SUCCESS);
        if (o != null) {
            result.setData(o);
        }
        return result;
    }

    public static Result messageResult(Errors errors) {
        Result result = new Result();
        result.setStatus("0");
        List<ObjectError> errorList = errors.getAllErrors();
        List<String> messages = new ArrayList<String>();
        for (ObjectError error : errorList) {
            messages.add(error.getDefaultMessage());
        }
        result.setMessage(messages);
        result.setMessage(errorList);
        return result;
    }

}
