package studio.jikewang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studio.jikewang.dao.CompanyDao;
import studio.jikewang.dao.StudentClassDao;
import studio.jikewang.dao.UserCompanyDao;
import studio.jikewang.entity.Company;
import studio.jikewang.entity.UserCompany;
import studio.jikewang.exception.ErrorException;
import studio.jikewang.util.Page;

import java.util.List;

/**
 * @author 李文浩
 * @version 2017/10/2.
 */

@Service
public class CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private UserCompanyDao userCompanyDao;

    @Autowired
    private StudentClassDao studentClassDao;

    /**
     * 创建公司
     * @param company
     * @param userId
     */
    public void saveCompany(Company company, String userId) {

        if (studentClassDao.getStudentClassByUserId(userId) == null) {
            throw new ErrorException("你不是老师指定的CEO");
        } else {
            company.setNumber(1);
            if (companyDao.saveCompany(company) != 1) {
                throw new ErrorException("创建公司不成功");
            }
            UserCompany userCompany = new UserCompany();
            userCompany.setCompanyId(company.getId());
            userCompany.setUserId(userId);
            userCompany.setPosition("CEO");
            if (userCompanyDao.saveUserCompany(userCompany) != 1) {
                throw new ErrorException("公司CEO进入userCompany表不成功");
            }
        }

    }

    /**
     * 删除公司
     * @param id
     */
    public void deleteCompany(int id) {
        if (companyDao.deleteCompany(id) == 0) {
            throw new ErrorException("没有这个公司");
        }
        userCompanyDao.deleteAllUserCompany(id);
    }

    /**
     * 得到单个公司
     * @param id
     * @return
     */
    public Company getCompany(int id) {
        return companyDao.getCompany(id);
    }

    /**
     * 查询公司名
     * @param page
     * @return
     */
    public List<Company> listCompaniesByStudentId(Page page) {
        return companyDao.listCompaniesByStudentId(page);
    }

    /**
     * 所有公司
     * @param page
     * @return
     */
    public List<Company> listCompaniesByTeacherId(Page page) {
        return companyDao.listCompaniesByTeacherId(page);
    }

    /**
     *更新公司
     * @param company
     */
    public void updateCompany(Company company) {
        companyDao.updateCompany(company);
    }

    public void updateCompanyBatch(List<Company> companies) {
        companyDao.updateCompanyBatch(companies);
    }
}
