package studio.jikewang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studio.jikewang.dao.CompanyDao;
import studio.jikewang.entity.Company;
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

    public void saveCompany(Company company) {
        company.setNumber(1);
        companyDao.saveCompany(company);
    }

    public void deleteCompany(int id) {
        if (companyDao.deleteCompany(id) == 0) {
            throw new ErrorException("没有这个公司");
        }
    }

    public Company getCompany(int id) {
        return companyDao.getCompany(id);
    }

    public List<Company> listCompaniesByName(Page page) {
        return companyDao.listCompaniesByName(page);
    }

    public List<Company> listCompanies(Page page) {
        return companyDao.listCompanies(page);
    }

    public void updateCompany(Company company) {
        companyDao.updateCompany(company);
    }
}
