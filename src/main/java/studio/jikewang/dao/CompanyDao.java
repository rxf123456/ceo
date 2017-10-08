package studio.jikewang.dao;

import org.springframework.stereotype.Repository;
import studio.jikewang.entity.Company;
import studio.jikewang.util.Page;

import java.util.List;

/**
 * @author 李文浩
 * @version 2017/10/2.
 */

@Repository
public interface CompanyDao {

    int saveCompany(Company company);

    int deleteCompany(int id);

    Company getCompany(int id);

    List<Company> listCompaniesByName(Page page);

    List<Company> listCompanies(Page page);

    int updateCompany(Company company);

}
