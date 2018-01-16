package studio.jikewang.action;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import studio.jikewang.dto.StudentClass;
import studio.jikewang.exception.ErrorException;
import studio.jikewang.service.StudentClassService;
import studio.jikewang.util.Page;
import studio.jikewang.util.Result;
import studio.jikewang.util.ResultUtil;
import studio.jikewang.util.Update;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 李文浩
 * @version 2017/10/2.
 */
@RestController
@RequestMapping("/studentclasses")
@Validated
public class StudentClassAction {
    @Autowired
    private StudentClassService studentClassService;

    @PostMapping
    public Result saveStudentClass(StudentClass studentClass) {
        studentClassService.saveStudentClass(studentClass);
        return ResultUtil.SUCCESS_RESULT;
    }

    @DeleteMapping("/{id}")
    public Result deleteStudentClass(@PathVariable int id) {
        studentClassService.deleteStudentClass(id);
        return ResultUtil.SUCCESS_RESULT;
    }

    @GetMapping("/getStudentClass")
    public Result getStudentClass(String userId) {
        return ResultUtil.successResult(studentClassService.getStudentClass(userId));
    }

    @GetMapping
    public Result listTeacherClasses(Page page, String teacherId, String userId, String userName) throws Exception {
        System.out.println(page);
        if (teacherId == null) {
            throw new ErrorException("老师id不为空");
        } else {
            page.getMap().put("teacherId", teacherId);
            if (userId != null) {
                page.getMap().put("userId", userId);
            }
            if (userName != null) {
                System.out.println(userName);
                userName = new String(userName.getBytes("ISO8859-1"), "UTF-8");
                System.out.println(userName);
                page.getMap().put("userName", userName);
            }
            List<StudentClass> list = studentClassService.listStudentClassesByTeacherId(page);
            page.setObject(list);
        }
        return ResultUtil.successResult(page);
    }

    @PutMapping("/{id}")
    public Result updateStudentClass(@PathVariable int id, String type) {
        StudentClass studentClass = new StudentClass();
        studentClass.setId(id);
        studentClass.setType(type);
        studentClassService.updateStudentClass(studentClass);
        return ResultUtil.SUCCESS_RESULT;
    }

    @PutMapping(consumes = "application/json")
    public Result updateStudentClassBatch(@Validated({Update.class}) @RequestBody List<StudentClass> studentClasses,
                                          Errors errors) {
        System.out.println(studentClasses);
        studentClassService.updateStudentClassBatch(studentClasses);
        return ResultUtil.SUCCESS_RESULT;
    }

    @GetMapping("/downloadStudentScore")
    public Result downloadStudentScore(@NotEmpty(message = "你必须传递老师ID") String teacherId,
                                       HttpServletResponse response) throws IOException {
        if (teacherId == null) {
            throw new ErrorException("必须传递老师ID");
        }
        studentClassService.generateStudentScore(teacherId);
        studentClassService.downloadStudentScore(teacherId, response);
        return ResultUtil.SUCCESS_RESULT;
    }

}
