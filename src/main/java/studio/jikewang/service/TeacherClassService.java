package studio.jikewang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studio.jikewang.dao.TeacherClassDao;
import studio.jikewang.dto.StudentClass;
import studio.jikewang.entity.TeacherClass;
import studio.jikewang.util.Page;

import java.util.List;

/**
 * @author 李文浩
 * @version 2017/10/9.
 */

@Service
public class TeacherClassService {

    @Autowired
    private TeacherClassDao teacherClassDao;

    public void saveTeacherClass(TeacherClass teacherClass) {

    }


    public void deleteTeacherClass(int id) {

    }

    public TeacherClass getTeacherClass(int id) {
        return teacherClassDao.getTeacherClass(id);
    }


    public List<StudentClass> listStudentClassesByTeacherId(Page page) {
        return teacherClassDao.listStudentClassesByTeacherId(page);
    }

    public void updateTeacherClass(TeacherClass teacherClass) {
        teacherClassDao.updateTeacherClass(teacherClass);
    }

}
