package studio.jikewang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studio.jikewang.dao.UserCompanyDao;
import studio.jikewang.entity.UserCompany;
import studio.jikewang.util.Page;

import java.util.List;

/**
 * @author 李文浩
 * @version 2017/10/9.
 */

@Service
public class UserCompanyService {

    @Autowired
    private UserCompanyDao userCompanyDao;

    public void saveUserCompany(UserCompany userCompany) {
        userCompanyDao.saveUserCompany(userCompany);
    }

    public void deleteUserCompany(int id) {
        userCompanyDao.deleteUserCompany(id);
    }

    public UserCompany getUserCompany(int id) {
        return userCompanyDao.getUserCompany(id);
    }

    public List<UserCompany> listUserCompanies(Page page) {
        return userCompanyDao.listUserCompanies(page);
    }

    public List<UserCompany> listUserCompaniesByCompanyId(Page page) {
        return userCompanyDao.listUserCompaniesByCompanyId(page);
    }

    public List<UserCompany> listUserCompaniesByUserId(Page page) {
        return userCompanyDao.listUserCompaniesByUserId(page);
    }

    public void updateUserCompany(UserCompany userCompany) {
        userCompanyDao.updateUserCompany(userCompany);
    }

}
