package studio.jikewang.dao;

import org.springframework.stereotype.Repository;
import studio.jikewang.dto.UserInfo;
import studio.jikewang.entity.UserCompany;
import studio.jikewang.util.Page;

import java.util.List;

/**
 * @author 李文浩
 * @version 2017/10/9.
 */
@Repository
public interface UserCompanyDao {
    /**
     * 公司增加成员
     *
     * @param userCompany
     * @return
     */
    int saveUserCompany(UserCompany userCompany);

    /**
     * 删除公司成员
     *
     * @param id
     * @return
     */
    int deleteUserCompany(int id);

    /**
     * 删除公司所有成员
     *
     * @param companyId
     * @return
     */
    int deleteAllUserCompany(int companyId);

    /**
     * 得到单个公司成员信息和所属公司的信息
     *
     * @param id
     * @return
     */
    UserInfo getUserInfo(int id);

    /**
     * 得到单个公司成员信息
     *
     * @param id
     * @return
     */
    UserCompany getUserCompany(int id);

    /**
     * 查看所有成员
     *
     * @param page
     * @return
     */
    List<UserInfo> listUserCompanies(Page page);

    /**
     * 公司查看所有成员
     *
     * @param page
     * @return
     */
    List<UserInfo> listUserCompaniesByCompanyId(Page page);

    /**
     * 学生查看公司信息-通过判断isScored属性来开启打分按钮
     *
     * @param page
     * @return
     */
    List<UserInfo> listUserCompaniesByUserId(Page page);


    /**
     * 公司成员职位信息更新
     *
     * @param userCompany
     * @return
     */
    int updateUserCompany(UserCompany userCompany);

    /**
     * 公司成员互评分
     *
     * @param userCompanies
     * @return
     */
    int updateUserCompanyBatch(List<UserCompany> userCompanies);

    int isTeacherScored(String userId);
}
