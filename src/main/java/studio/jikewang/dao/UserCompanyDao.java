package studio.jikewang.dao;

import org.springframework.stereotype.Repository;
import studio.jikewang.dto.ClassNum;
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

    int saveUserCompany(UserCompany userCompany);

    int deleteUserCompany(int id);

    int deleteAllUserCompany(int companyId);

    UserInfo getUserCompany(int id);

    List<UserInfo> listUserCompanies(Page page);

    List<UserInfo> listUserCompaniesByCompanyId(Page page);

    List<UserInfo> listUserCompaniesByUserId(Page page);

    ClassNum getClassNumByUserId(String userId);

    int updateUserCompany(UserCompany userCompany);


}
