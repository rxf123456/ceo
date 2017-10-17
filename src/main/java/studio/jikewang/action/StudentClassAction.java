package studio.jikewang.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import studio.jikewang.entity.StudentClass;
import studio.jikewang.service.StudentClassService;
import studio.jikewang.util.Insert;
import studio.jikewang.util.Page;
import studio.jikewang.util.Result;
import studio.jikewang.util.ResultUtil;

import java.util.List;

/**
 * @author 李文浩
 * @version 2017/10/2.
 */
@RestController
@RequestMapping("/studentclasses")
public class StudentClassAction {
    @Autowired
    private StudentClassService studentClassService;

    @PostMapping
    public Result saveStudentClass(@Validated({Insert.class}) StudentClass studentClass,
                              Errors errors) {
        studentClassService.saveStudentClass(studentClass);
        return ResultUtil.SUCCESS_RESULT;
    }

    @DeleteMapping("/{id}")
    public Result deleteStudentClass(@PathVariable int id) {
        studentClassService.deleteStudentClass(id);
        return ResultUtil.SUCCESS_RESULT;
    }

    @GetMapping("/{id}")
    public Result getStudentClass(@PathVariable int id) {
        return ResultUtil.successResult(studentClassService.getStudentClass(id));
    }

    @GetMapping
    public Result listStudentClasses(Page page, String classId) {
        System.out.println(page);
        if (classId == null) {
            page.setObject(studentClassService.listStudentClasses(page));
        } else {
            page.setObject(classId);
            List<StudentClass> list = studentClassService.listStudentClassesByClassId(page);
            page.setObject(list);
        }
        return ResultUtil.successResult(page);
    }

    @PutMapping("/{id}")
    public Result updateStudentClass(@PathVariable int id,
                                     @Validated StudentClass studentClass,
                                     Errors errors) {
        studentClass.setId(id);
        System.out.println(studentClass);
        studentClassService.updateStudentClass(studentClass);
        return ResultUtil.SUCCESS_RESULT;
    }
}
