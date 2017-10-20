package studio.jikewang.dao;

import org.springframework.stereotype.Repository;
import studio.jikewang.entity.Application;
import studio.jikewang.util.Page;

import java.util.List;

/**
 * @author 李文浩
 * @version 2017/10/2.
 */

@Repository
public interface ApplicationDao {

    int saveApplication(Application application);

    int saveApplicationBatch(List<Application> applications);

    int deleteApplication(int id);

    int deleteApplicationBatch(List<Integer> ids);

    Application getApplication(int id);

    List<Application> listApplicationsByCompanyId(Page page);

    List<Application> listApplicationsByUserId(Page page);

    List<Application> listApplications(Page page);

    int updateApplication(Application application);

}
