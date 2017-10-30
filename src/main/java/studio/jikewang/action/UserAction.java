package studio.jikewang.action;

import lab.bean.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import studio.jikewang.util.Result;
import studio.jikewang.util.ResultUtil;

import java.io.IOException;

/**
 * @author 李文浩
 * @version 2017/10/27.
 */

@RestController
public class UserAction {

    @RequestMapping("/userInfo")
    public Result session(@SessionAttribute User user) throws IOException {
        return ResultUtil.successResult(user);
    }
}
