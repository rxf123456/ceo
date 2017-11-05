package studio.jikewang.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import studio.jikewang.dto.UserInfo;
import studio.jikewang.entity.UserCompany;
import studio.jikewang.service.UserCompanyService;
import studio.jikewang.util.*;

import java.util.List;

/**
 * @author 李文浩
 * @version 2017/10/2.
 */
@RestController
@RequestMapping("/usercompanies")
public class UserCompanyAction {
    @Autowired
    private UserCompanyService userCompanyService;

    @PostMapping
    public Result saveUserCompany(@Validated({Insert.class}) UserCompany userCompany,
                                  Errors errors) {
        userCompanyService.saveUserCompany(userCompany);
        return ResultUtil.SUCCESS_RESULT;
    }

    @DeleteMapping("/{id}")
    public Result deleteUserCompany(@PathVariable int id) {
        userCompanyService.deleteUserCompany(id);
        return ResultUtil.SUCCESS_RESULT;
    }

    @GetMapping("/{id}")
    public Result getUserCompany(@PathVariable int id) {
        return ResultUtil.successResult(userCompanyService.getUserInfo(id));
    }

    @GetMapping
    public Result listUserCompanyes(Page page, String companyId, String userId) {
        System.out.println(page);
        if (companyId == null && userId == null) {
            page.setObject(userCompanyService.listUserCompanies(page));
        } else {
            if (userId == null) {
                page.setObject(companyId);
                List<UserInfo> list = userCompanyService.listUserCompaniesByCompanyId(page);
                page.setObject(list);
            } else {
                page.setObject(userId);
                List<UserInfo> list = userCompanyService.listUserCompaniesByUserId(page);
                page.setObject(list);
            }
        }
        return ResultUtil.successResult(page);
    }

    @PutMapping("/{id}")
    public Result updateUserCompany(@PathVariable int id,
                                     UserCompany userCompany) {
        userCompany.setId(id);
        System.out.println(userCompany);
        userCompanyService.updateUserCompany(userCompany);
        return ResultUtil.SUCCESS_RESULT;
    }


}
