package studio.jikewang.service;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studio.jikewang.dao.StudentClassDao;
import studio.jikewang.dto.StudentClass;
import studio.jikewang.exception.ErrorException;
import studio.jikewang.util.Page;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
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

    public StudentClass getStudentClass(String userId) {
        return studentClassDao.getStudentClass(userId);
    }

    public StudentClass getStudentClassByUserId(String id) {
        return studentClassDao.getStudentClassByUserId(id);
    }

    public List<StudentClass> listStudentClasses(Page page) {
        return studentClassDao.listStudentClasses(page);
    }

    public List<StudentClass> listStudentClassesByClassId(Page page) {
        return studentClassDao.listStudentClassesByClassId(page);
    }

    public List<StudentClass> listStudentClassesByTeacherId(Page page) {
        return studentClassDao.listStudentClassesByTeacherId(page);
    }

    public void updateStudentClass(StudentClass studentClass) {
        studentClassDao.updateStudentClass(studentClass);
    }

    public void updateStudentClassBatch(List<StudentClass> studentClasses) {
        studentClassDao.updateStudentClassBatch(studentClasses);
    }

    public void generateStudentScore(String teacherId) throws IOException {
        List<StudentClass> studentClasses = studentClassDao.getStudentScore(teacherId);
        System.out.println(studentClasses);
        for (StudentClass studentClass : studentClasses) {
            if (studentClass.getTeacherScore() == null) {
                System.out.println(studentClass.getTeacherScore());
                throw new ErrorException("老师没有给" + studentClass.getUserId() + "打分");
            } else if (studentClass.getCompanyScore() == null) {
                throw new ErrorException("公司没有给" + studentClass.getUserId() + "打分");
            } else if (studentClass.getStudentScore() == null) {
                throw new ErrorException("学生没有给" + studentClass.getUserId() + "打分");
            }
        }
        for (StudentClass studentClass : studentClasses) {
            studentClass.setScore(studentClass.getCompanyScore() * 0.4 + studentClass.getTeacherScore() * 0.3
                    + studentClass.getStudentScore() * 0.3);
            studentClass.setTeacherScore(null);
        }
        studentClassDao.updateStudentClassBatch(studentClasses);
    }

    public void downloadStudentScore(String teacherId, HttpServletResponse response) throws IOException {
        List<StudentClass> studentClasses = studentClassDao.getStudentScore(teacherId);
        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet = wb.createSheet("学生成绩表");
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1 = sheet.createRow(0);
        //创建单元格并设置单元格内容 学号 姓名	班级	专业名	年级	老师评分	公司分数	成员互评
        row1.createCell(0).setCellValue("学号");
        row1.createCell(1).setCellValue("姓名");
        row1.createCell(2).setCellValue("班级");
        row1.createCell(3).setCellValue("专业名");
        row1.createCell(4).setCellValue("年级");
        row1.createCell(5).setCellValue("老师评分");
        row1.createCell(6).setCellValue("公司分数");
        row1.createCell(7).setCellValue("成员互评");
        row1.createCell(8).setCellValue("学生总分");
        //在sheet里创建第三行
        HSSFRow row;
        int i = 1;
        for (StudentClass studentClass : studentClasses) {
            row = sheet.createRow(i++);
            row.createCell(0).setCellValue(studentClass.getUserId());
            row.createCell(1).setCellValue(studentClass.getUserName());
            row.createCell(2).setCellValue(studentClass.getCls());
            row.createCell(3).setCellValue(studentClass.getDiscipline());
            row.createCell(4).setCellValue(studentClass.getGrade());
            row.createCell(5).setCellValue(studentClass.getTeacherScore());
            row.createCell(6).setCellValue(studentClass.getCompanyScore());
            row.createCell(7).setCellValue(studentClass.getStudentScore());
            row.createCell(8).setCellValue(studentClass.getScore());
        }

        //输出Excel文件
        OutputStream output=response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=studentScore.xls");
        response.setContentType("application/msexcel");
        wb.write(output);
        output.close();
    }
}
