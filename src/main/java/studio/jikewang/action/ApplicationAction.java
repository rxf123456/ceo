package studio.jikewang.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import studio.jikewang.entity.Application;
import studio.jikewang.service.ApplicationService;
import studio.jikewang.util.Page;
import studio.jikewang.util.Result;
import studio.jikewang.util.ResultUtil;

import java.util.List;


/**
 * @author 李文浩
 * @version 2017/10/2.
 */
@RestController
@RequestMapping("/applications")
public class ApplicationAction {
    @Autowired
    private ApplicationService applicationService;

    /**
     * 学生提交多个公司的申请
     *
     * @param applications
     * @param errors
     * @return
     */
    @PostMapping(consumes = "application/json")
    public Result saveApplicationBatch(@Validated @RequestBody List<Application> applications,
                                       Errors errors) {
        applicationService.saveApplicationBatch(applications);
        return ResultUtil.SUCCESS_RESULT;
    }

    /**
     *
     * 公司CEO接受某个学生的申请
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result deleteApplication(@PathVariable int id) {
        applicationService.deleteApplication(id);
        return ResultUtil.SUCCESS_RESULT;
    }

    /**
     * 通过id得到某条具体的申请信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getApplication(@PathVariable int id) {
        return ResultUtil.successResult(applicationService.getApplication(id));
    }

    /**
     * 所有申请信息
     * @param page 分页
     * @param companyId CEO查看申请的所有学生及其志愿级别
     * @param userId 学生查看申请的所有公司信息
     * @return
     */
    @GetMapping
    public Result listApplicationsByCompanyId(Page page, String companyId, String userId) {
        if (companyId == null && userId == null) {
            page.setObject(applicationService.listApplications(page));
        } else {
            if (userId == null) {
                page.setObject(companyId);
                List<Application> list = applicationService.listApplicationsByCompanyId(page);
                page.setObject(list);
            } else {
                page.setObject(userId);
                List<Application> list = applicationService.listApplicationsByUserId(page);
                page.setObject(list);
            }
        }
        return ResultUtil.successResult(page);
    }

    /**
     * 公司CEO拒绝某个学生的申请
     * @param id
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public Result updateApplication(@PathVariable int id) {
        applicationService.updateApplication(id);
        return ResultUtil.SUCCESS_RESULT;
    }
}
