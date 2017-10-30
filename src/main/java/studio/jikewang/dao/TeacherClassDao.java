package studio.jikewang.dao;

import org.springframework.stereotype.Repository;
import studio.jikewang.entity.Company;
import studio.jikewang.dto.StudentClass;
import studio.jikewang.entity.TeacherClass;
import studio.jikewang.util.Page;

import java.util.List;

/**
 * @author 李文浩
 * @version 2017/10/9.
 */
@Repository
public interface TeacherClassDao {

    int saveTeacherClass(TeacherClass teacherClass);

    int deleteTeacherClass(int id);

    TeacherClass getTeacherClass(int id);

    List<StudentClass> listStudentClassesByTeacherId(Page page);

    List<Company> listCompaniesByTeacherId(Page page);

    int updateTeacherClass(TeacherClass teacherClass);


}
