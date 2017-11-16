package studio.jikewang.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import studio.jikewang.entity.TeacherClass;
import studio.jikewang.service.TeacherClassService;
import studio.jikewang.util.Insert;
import studio.jikewang.util.Result;
import studio.jikewang.util.ResultUtil;

/**
 * @author 李文浩
 * @version 2017/10/2.
 */
@RestController
@RequestMapping("/teacherclasses")
public class TeacherClassAction {
    @Autowired
    private TeacherClassService teacherClassService;

    @PostMapping("/")
        public Result saveTeacherClass(@Validated({Insert.class}) TeacherClass teacherClass,
                                   Errors errors) {
        teacherClassService.saveTeacherClass(teacherClass);
        return ResultUtil.SUCCESS_RESULT;
    }

    @DeleteMapping("/{id}")
    public Result deleteTeacherClass(@PathVariable int id) {
        teacherClassService.deleteTeacherClass(id);
        return ResultUtil.SUCCESS_RESULT;
    }

    @GetMapping("/{id}")
    public Result getTeacherClass(@PathVariable int id) {
        return ResultUtil.successResult(teacherClassService.getTeacherClass(id));
    }

//    @GetMapping
//    public Result listTeacherClasses(Page page, String teacherId, String userId, String userName) throws Exception {
//        System.out.println(page);
//        if (teacherId == null) {
//            throw new ErrorException("老师id不为空");
//        } else {
//            page.getMap().put("teacherId", teacherId);
//            if (userId != null) {
//                page.getMap().put("userId", userId);
//            }
//            if (userName != null) {
//                System.out.println(userName);
//                userName = new String(userName.getBytes("ISO8859-1"), "UTF-8");
//                System.out.println(userName);
//                page.getMap().put("userName", userName);
//            }
//            List<StudentClass> list = teacherClassService.listStudentClassesByTeacherId(page);
//            page.setObject(list);
//        }
//        return ResultUtil.successResult(page);
//    }

    @PutMapping("/{id}")
    public Result updateTeacherClass(@PathVariable int id,
                                     @Validated TeacherClass teacherClass,
                                     Errors errors) {
        teacherClass.setId(id);
        System.out.println(teacherClass);
        teacherClassService.updateTeacherClass(teacherClass);
        return ResultUtil.SUCCESS_RESULT;
    }
}
