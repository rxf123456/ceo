package studio.jikewang.dao;

import org.springframework.stereotype.Repository;
import studio.jikewang.dto.StudentClass;
import studio.jikewang.entity.Company;
import studio.jikewang.util.Page;

import java.util.List;

/**
 * @author 李文浩
 * @version 2017/10/9.
 */
@Repository
public interface StudentClassDao {

    int saveStudentClass(StudentClass studentClass);

    int saveStudentClassBatch(List<StudentClass> studentClasses);

    int deleteStudentClass(int id);

    StudentClass getStudentClass(String id);

    StudentClass getStudentClassByUserId(String id);

    List<StudentClass> listStudentClasses(Page page);

    List<StudentClass> listStudentClassesByClassId(Page page);

    int updateStudentClass(StudentClass studentClass);

    int updateStudentClassBatch(List<StudentClass> studentClasses);

    List<StudentClass> getStudentScore(String teacherId);

    List<StudentClass> listStudentClassesByTeacherId(Page page);

    List<Company> listCompaniesByTeacherId(Page page);
}
