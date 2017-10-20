package studio.jikewang.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
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

    @PostMapping(consumes = "application/json")
    public Result saveApplicationBatch(@RequestBody List<Application> applications,
                                       Errors errors) {
        applicationService.saveApplicationBatch(applications);
        return ResultUtil.SUCCESS_RESULT;
    }

    @DeleteMapping("/{id}")
    public Result deleteApplication(@PathVariable int id) {
        applicationService.deleteApplication(id);
        return ResultUtil.SUCCESS_RESULT;
    }

    @DeleteMapping
    public Result deleteApplicationBatch(@PathVariable int id) {
        applicationService.deleteApplication(id);
        return ResultUtil.SUCCESS_RESULT;
    }

    @GetMapping("/{id}")
    public Result getApplication(@PathVariable int id) {
        return ResultUtil.successResult(applicationService.getApplication(id));
    }

    @GetMapping
    public Result listApplicationsByCompanyId(Page page,String companyId, String userId) {
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

    @PutMapping("/{id}")
    public Result updateApplication(@PathVariable int id,
                                    Application application) {
        application.setId(id);
        applicationService.updateApplication(application);
        return ResultUtil.SUCCESS_RESULT;
    }
}
