package studio.jikewang.action;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import studio.jikewang.entity.Company;
import studio.jikewang.service.CompanyService;
import studio.jikewang.util.*;

import java.util.List;

/**
 * @author 李文浩
 * @version 2017/10/2.
 */
@RestController
@RequestMapping("/company")
public class CompanyAction {
    @Autowired
    private CompanyService companyService;

    @PostMapping("/")
    public Result saveCompany(@Validated({Insert.class}) Company company,
                              @Validated @NotEmpty String userId,
                              Errors errors) {
        companyService.saveCompany(company,userId);
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

    @GetMapping("/companies")
    public Result listCompanies(Page page, String name) {
        System.out.println(page);
        if (name == null) {
            page.setObject(companyService.listCompanies(page));
        } else {
            page.setObject(name);
            List<Company> list = companyService.listCompaniesByName(page);
            page.setObject(list);
        }
        return ResultUtil.successResult(page);
    }

    @PutMapping("/{id}")
    public Result updateCompany(@PathVariable int id,
                                @Validated({Update.class})Company company,
                                Errors errors) {
        company.setId(id);
        companyService.updateCompany(company);
        return ResultUtil.SUCCESS_RESULT;
    }
}
