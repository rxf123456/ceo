package studio.jikewang.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studio.jikewang.util.Result;
import studio.jikewang.util.ResultUtil;

/**
 * @author 李文浩
 * @version 2017/10/9.
 */
@RestController
public class ErrorAction {

    @RequestMapping(value = "/error_404")
    public Result error_404(){
        return ResultUtil.NOT_FOUND_RESULT;
    }
}
