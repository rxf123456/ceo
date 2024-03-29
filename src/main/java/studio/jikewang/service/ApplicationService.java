package studio.jikewang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studio.jikewang.dao.ApplicationDao;
import studio.jikewang.dao.CompanyDao;
import studio.jikewang.dao.StudentClassDao;
import studio.jikewang.dto.ClassNum;
import studio.jikewang.entity.Application;
import studio.jikewang.entity.Company;
import studio.jikewang.entity.UserCompany;
import studio.jikewang.exception.ErrorException;
import studio.jikewang.util.Page;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 李文浩
 * @version 2017/10/20.
 */

@Service
public class ApplicationService {

    @Autowired
    private ApplicationDao applicationDao;

    @Autowired
    private UserCompanyService userCompanyService;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private StudentClassDao studentClassDao;

    /**
     * 学生申请公司
     *
     * @param applications
     */
    public void saveApplicationBatch(List<Application> applications) {
        for (Application application : applications) {
            Company compnay = companyDao.getCompany(application.getCompanyId());
            if (compnay.getNumber() >= Company.MAX_NUMBER) {
                throw new ErrorException(compnay.getName() + "已经有了7个人了,你不能提交这次申请");
            }
            if (compnay.getIsScored() == 1) {
                throw new ErrorException(compnay.getName() + "已经关闭了申请加入");
            }
            if (studentClassDao.getStudentClassByUserId(application.getUserId()) == null) {
                throw new ErrorException("你没有报名此次CEO实验课程");
            }
            ClassNum classNum = applicationDao.getClassNumByUserId(application);
            if (classNum.getNum() >= Company.CLASS_NUM) {
                throw new ErrorException("在" + compnay.getName() + "公司中" + classNum.getCls() + "班已经有了3个人，你不能提交这次申请");
            }
        }
        applicationDao.saveApplicationBatch(applications);
    }

    /**
     * 有公司CEO已经接受这个学生的申请，删除这个学生的所有申请
     *
     * @param id
     */
    public void deleteApplication(int id) {
        Application application = getApplication(id);
        Date now = new Date();
        Date startTime = new Date(application.getModifiedTime().getTime() + 10 * 60 * 1000 * (application.getCalculatedGrade() - 1));
        Date failureTime = new Date(application.getModifiedTime().getTime() + 10 * 60 * 1000 * application.getCalculatedGrade());
        // 在开始时间之前和截止时间之后
        if (now.after(startTime) &&
                failureTime.after(now)) {
            UserCompany userCompany = new UserCompany();
            userCompany.setUserId(application.getUserId());
            userCompany.setCompanyId(application.getCompanyId());
            userCompanyService.saveUserCompany(userCompany);
            applicationDao.deleteApplicationByUserId(application.getUserId());
        } else {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(now.after(startTime) &&
                    failureTime.after(now));
            System.out.println(df.format(startTime));
            System.out.println(df.format(failureTime));
            throw new ErrorException("现在你没有权限接受这个学生的申请，请在" + df.format(failureTime) + "再来尝试，或者等待" + application.getUserId() + "被其他公司拒绝");
        }
    }


    public Application getApplication(int id) {
        return applicationDao.getApplication(id);
    }

    public List<Application> listApplicationsByCompanyId(Page page) {
        return applicationDao.listApplicationsByCompanyId(page);
    }

    public List<Application> listApplicationsByUserId(Page page) {
        return applicationDao.listApplicationsByUserId(page);

    }

    public List<Application> listApplications(Page page) {
        return applicationDao.listApplications(page);
    }

    /**
     * 公司CEO拒绝某个学生的申请
     *
     * @param id
     */
    public void updateApplication(int id) {
        Application application = getApplication(id);
        Date now = new Date();
        Date startTime = new Date(application.getModifiedTime().getTime() + 10 * 60 * 1000 * (application.getCalculatedGrade() - 1));
        Date failureTime = new Date(application.getModifiedTime().getTime() + 10 * 60 * 1000 * application.getCalculatedGrade());
        // 在开始时间和失效时间之间
        if (now.after(startTime) &&
                failureTime.after(now)) {
            applicationDao.deleteApplication(application.getId());
            applicationDao.updateApplication(application.getUserId());
        } else {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            throw new ErrorException("现在你没有权限拒绝这个学生的申请，请在" + df.format(failureTime) + "再来尝试");
        }
    }

    /**
     *
     * 清除失效的application记录
     */
    public void clearExpiredApplication() {
        int num = applicationDao.clearExpiredApplication();
        if (num != 0) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(df.format(new Date()) + "清除了application表中" + num + "条失效的请求记录");
        }
    }

}
