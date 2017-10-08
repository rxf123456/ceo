package studio.jikewang.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 赵涛涛
 * @version 2017/5/23.
 */
public class CheckFieldUtil {

    public static Result checkField(BindingResult bindingResult) {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            List<ObjectError> errorList = bindingResult.getAllErrors();
            List<String> errorMessages = new ArrayList<String>();
            for (ObjectError error : errorList) {
                String str = error.getDefaultMessage();
                //控制台打印
                System.out.println("error:"+str);
                errorMessages.add(str);
            }
            result.setStatus("0");
            result.setMessage("fail");
            result.setData(errorMessages);
            return result;
        }
        return null;
    }
}
