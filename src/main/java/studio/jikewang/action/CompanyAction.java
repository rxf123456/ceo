package studio.jikewang.action;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import studio.jikewang.entity.Company;
import studio.jikewang.exception.ErrorException;
import studio.jikewang.service.CompanyService;
import studio.jikewang.util.Insert;
import studio.jikewang.util.Page;
import studio.jikewang.util.Result;
import studio.jikewang.util.ResultUtil;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author 李文浩
 * @version 2017/10/2.
 */
@RestController
@RequestMapping("/companies")
public class CompanyAction {
    @Autowired
    private CompanyService companyService;

    @PostMapping
    public Result saveCompany(@Validated({Insert.class}) Company company,
                              @Validated @NotEmpty String userId,
                              Errors errors) {
        companyService.saveCompany(company, userId);
        return ResultUtil.SUCCESS_RESULT;
    }

    @DeleteMapping("/{id}")
    public Result deleteCompany(@PathVariable int id) {
        companyService.deleteCompany(id);
        return ResultUtil.SUCCESS_RESULT;
    }

    @GetMapping("/{id}")
    public Result getCompany(@PathVariable int id) {
        return ResultUtil.successResult(companyService.getCompany(id));
    }

    @GetMapping
    public Result listCompanies(Page page, String teacherId, String studentId, String name) throws UnsupportedEncodingException {

        if (name != null) {
            name = new String(name.getBytes("ISO8859-1"), "UTF-8");
            page.getMap().put("name", name);
        }
        List<Company> list;
        if (teacherId == null && studentId != null) {
            page.setObject(studentId);
            list = companyService.listCompaniesByStudentId(page);
        } else if (studentId == null && teacherId != null) {
            page.setObject(teacherId);
            list = companyService.listCompaniesByTeacherId(page);
        } else {
            throw new ErrorException("只能传递学生的学号或者老师的id其中一个");
        }
        page.setObject(list);
        return ResultUtil.successResult(page);
    }

    @PutMapping("/{id}")
    public Result updateCompany(@PathVariable int id,
                                Company company) {
        company.setId(id);
        if (company.getIsScored() != null) {
            if (company.getIsScored() != 1) {
                throw new ErrorException("你只可以关闭别人加入公司，然后开始打分");
            }
        }
        companyService.updateCompany(company);
        return ResultUtil.SUCCESS_RESULT;
    }
}
