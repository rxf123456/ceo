package studio.jikewang.dao;

import org.springframework.stereotype.Repository;
import studio.jikewang.dto.ClassNum;
import studio.jikewang.entity.Application;
import studio.jikewang.util.Page;

import java.util.List;

/**
 * @author 李文浩
 * @version 2017/10/2.
 */

@Repository
public interface ApplicationDao {

    /**
     * 学生申请公司
     *
     * @param applications
     * @return
     */
    int saveApplicationBatch(List<Application> applications);

    /**
     * 删除某条申请
     *
     * @param id
     * @return
     */
    int deleteApplication(int id);

    /**
     * 有公司CEO已经接受这个学生的申请，删除这个学生的所有申请
     *
     * @param userId
     * @return
     */
    int deleteApplicationByUserId(String userId);


    /**
     * 通过id得到某条具体的申请信息
     *
     * @param userId
     * @return
     */
    Application getApplication(int userId);

    /**
     * CEO查看申请的所有学生及其志愿级别
     *
     * @param page
     * @return
     */
    List<Application> listApplicationsByCompanyId(Page page);

    /**
     * 学生查看申请的所有公司信息
     *
     * @param page
     * @return
     */
    List<Application> listApplicationsByUserId(Page page);

    /**
     * 所有申请信息
     *
     * @param page
     * @return
     */
    List<Application> listApplications(Page page);

    /**
     * 得到公司现有的每个班级的人数
     * @param application
     * @return
     */
    ClassNum getClassNumByUserId(Application application);

    /**
     * 公司CEO拒绝某个学生的申请
     *
     * @param userId
     * @return
     */
    int updateApplication(String userId);

}
