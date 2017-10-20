package studio.jikewang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studio.jikewang.dao.CompanyDao;
import studio.jikewang.dao.UserCompanyDao;
import studio.jikewang.dto.ClassNum;
import studio.jikewang.dto.UserInfo;
import studio.jikewang.entity.Company;
import studio.jikewang.entity.UserCompany;
import studio.jikewang.exception.ErrorException;
import studio.jikewang.util.Page;

import java.util.List;

/**
 * @author 李文浩
 * @version 2017/10/9.
 */

@Service
public class UserCompanyService {
    /**
     * 在这个公司的每个班的最多人数,防止一个寝室的都选一个公司
     */
    private final static int CLASS_NUM = 3;
    private final static String CEO = "CEO";
    @Autowired
    private UserCompanyDao userCompanyDao;

    @Autowired
    private CompanyDao companyDao;

    public void saveUserCompany(UserCompany userCompany) {
        String userId = userCompany.getUserId();
        ClassNum classNum = userCompanyDao.getClassNumByUserId(userId);
        System.out.println(classNum);
        System.out.println(classNum.getNum());
        if (classNum.getNum() >= CLASS_NUM) {
            throw new ErrorException(classNum.getCls() + "班已经有了3个人，不能再加入了，请叫他加入别的公司");
        }
        int companyId = userCompany.getCompanyId();
        if (companyDao.getCompany(companyId).getNumber() >= Company.MAX_NUMBER) {
            throw new ErrorException("你的公司已经有了" + Company.MAX_NUMBER + "个人了,不能在加入");
        }
        userCompanyDao.saveUserCompany(userCompany);
        companyDao.numberPlusOne(companyId);
    }

    public void deleteUserCompany(int id) {
        UserInfo userCompany = getUserCompany(id);
        int companyId = userCompany.getCompanyId();
        if (CEO.equals(userCompany.getPosition())) {
            companyDao.deleteCompany(companyId);
            userCompanyDao.deleteAllUserCompany(companyId);
        } else {
            userCompanyDao.deleteUserCompany(id);
            companyDao.numberMinusOne(companyId);
        }
    }

    public UserInfo getUserCompany(int id) {
        return userCompanyDao.getUserCompany(id);
    }

    public List<UserInfo> listUserCompanies(Page page) {
        return userCompanyDao.listUserCompanies(page);
    }

    public List<UserInfo> listUserCompaniesByCompanyId(Page page) {
        return userCompanyDao.listUserCompaniesByCompanyId(page);
    }

    public List<UserInfo> listUserCompaniesByUserId(Page page) {
        return userCompanyDao.listUserCompaniesByUserId(page);
    }

    public void updateUserCompany(UserCompany userCompany) {
        int num = getUserCompany(userCompany.getId()).getNumber();
        userCompany.setScore(userCompany.getScore() / num);
        userCompanyDao.updateUserCompany(userCompany);
    }

}
