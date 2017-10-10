package studio.jikewang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studio.jikewang.dao.StudentClassDao;
import studio.jikewang.entity.StudentClass;
import studio.jikewang.util.Page;

import java.util.List;

/**
 * @author 李文浩
 * @version 2017/10/9.
 */

@Service
public class StudentClassService {

    @Autowired
    private StudentClassDao studentClassDao;

    public void saveStudentClass(StudentClass studentClass) {

    }

    public void saveStudentClassBatch(List<StudentClass> studentClasses) {

    }

    public void deleteStudentClass(int id) {

    }

    public StudentClass getStudentClass(int id) {
        return studentClassDao.getStudentClass(id);
    }

    public List<StudentClass> listStudentClasses(Page page) {
        return studentClassDao.listStudentClasses(page);
    }

    public List<StudentClass> listStudentClassesByClassId(Page page) {
        return studentClassDao.listStudentClassesByClassId(page);
    }

    public void updateStudentClass(StudentClass studentClass) {
        studentClassDao.updateStudentClass(studentClass);
    }

}
