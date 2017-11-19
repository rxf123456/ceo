package studio.jikewang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studio.jikewang.dao.CompanyDao;
import studio.jikewang.dao.UserCompanyDao;
import studio.jikewang.dto.UserInfo;
import studio.jikewang.entity.UserCompany;
import studio.jikewang.exception.ErrorException;
import studio.jikewang.util.Page;

import java.util.List;

import static studio.jikewang.entity.Company.CEO;

/**
 * @author 李文浩
 * @version 2017/10/9.
 */

@Service
public class UserCompanyService {

    @Autowired
    private UserCompanyDao userCompanyDao;

    @Autowired
    private CompanyDao companyDao;


    /**
     * 公司增加成员
     *
     * @param userCompany
     */
    public void saveUserCompany(UserCompany userCompany) {
        userCompanyDao.saveUserCompany(userCompany);
        companyDao.numberPlusOne(userCompany.getCompanyId());
    }

    /**
     * 删除公司成员
     *
     * @param id
     */
    public void deleteUserCompany(int id) {
        UserInfo userCompany = getUserInfo(id);
        int companyId = userCompany.getCompanyId();
        if (CEO.equals(userCompany.getPosition())) {
            companyDao.deleteCompany(companyId);
            userCompanyDao.deleteAllUserCompany(companyId);
        } else {
            userCompanyDao.deleteUserCompany(id);
            companyDao.numberMinusOne(companyId);
        }
    }

    /**
     * 得到单个公司成员信息和所属公司的信息
     *
     * @param id
     * @return
     */
    public UserInfo getUserInfo(int id) {
        return userCompanyDao.getUserInfo(id);
    }

    /**
     * 得到单个公司成员信息
     *
     * @param id
     * @return
     */
    public UserCompany getUserCompany(int id) {
        return userCompanyDao.getUserCompany(id);
    }

    /**
     * 查看所有成员
     *
     * @param page
     * @return
     */
    public List<UserInfo> listUserCompanies(Page page) {
        return userCompanyDao.listUserCompanies(page);
    }

    /**
     * 公司查看所有成员
     *
     * @param page
     * @return
     */
    public List<UserInfo> listUserCompaniesByCompanyId(Page page) {
        return userCompanyDao.listUserCompaniesByCompanyId(page);
    }

    /**
     * 学生查看公司信息-通过判断isScored属性来开启打分按钮
     *
     * @param page
     * @return
     */
    public List<UserInfo> listUserCompaniesByUserId(Page page) {
        return userCompanyDao.listUserCompaniesByUserId(page);
    }

    /**
     * 公司成员职位信息更新
     *
     * @param userCompany
     */
    public void updateUserCompany(UserCompany userCompany) {
        userCompanyDao.updateUserCompany(userCompany);
    }

    /**
     * 公司成员互评分
     *
     * @param userCompanies
     */
    public void updateUserCompanyBatch(List<UserCompany> userCompanies) {
        UserCompany userCompany = userCompanies.get(0);
        if (getUserCompany(userCompany.getId()).getScored() == 1) {
            throw new ErrorException("你已经给本公司的成员打分了");
        }
        UserInfo userInfo = getUserInfo(userCompany.getId());
        if (userInfo.getIsScored() == 0) {
            throw new ErrorException(userInfo.getCompanyName() + "还未开始打分");
        }
        if (userCompanies.size() != userInfo.getNumber()) {
            throw new ErrorException("请为所有学生打分");
        }
        userCompanies.remove(0);
        int num = userInfo.getNumber() - 1;
        for (UserCompany userCompany1 : userCompanies) {
            userCompany1.setScore(userCompany1.getScore() / num);
        }
        userCompanyDao.updateUserCompanyBatch(userCompanies);
        userCompany.setScored(1);
        userCompanyDao.updateUserCompany(userCompany);
    }
}