package studio.jikewang.dao;

import org.springframework.stereotype.Repository;
import studio.jikewang.entity.UserCompany;
import studio.jikewang.util.Page;

import java.util.List;

/**
 * @author 李文浩
 * @version 2017/10/9.
 */
@Repository
public interface UserCompanyDao {

    int saveUserCompany(UserCompany userCompany);

    int deleteUserCompany(int id);

    UserCompany getUserCompany(int id);

    List<UserCompany> listUserCompanies(Page page);

    List<UserCompany> listUserCompaniesByCompanyId(Page page);

    List<UserCompany> listUserCompaniesByUserId(Page page);

    int updateUserCompany(UserCompany userCompany);


}
