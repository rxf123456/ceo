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
    /**
     * 创建公司
     * @param company
     * @return
     */
    int saveCompany(Company company);

    /**
     *删除公司
     * @param id
     * @return
     */
    int deleteCompany(int id);

    /**
     *得到单个公司
     * @param id
     * @return
     */
    Company getCompany(int id);

    /**
     * 查询公司名
     * @param page
     * @return
     */
    List<Company> listCompaniesByName(Page page);

    /**
     *所有公司
     * @param page
     * @return
     */
    List<Company> listCompanies(Page page);

    /**
     *更新公司
     * @param company
     * @return
     */
    int updateCompany(Company company);

    /**
     *公司人数加1
     * @param companyId
     * @return
     */
    int numberPlusOne(int companyId);

    /**
     *公司人数减1
     * @param companyId
     * @return
     */
    int numberMinusOne(int companyId);
}
