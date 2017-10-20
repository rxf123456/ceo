package studio.jikewang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studio.jikewang.dao.ApplicationDao;
import studio.jikewang.entity.Application;
import studio.jikewang.util.Page;

import java.util.List;

/**
 * @author 李文浩
 * @version 2017/10/20.
 */

@Service
public class ApplicationService {

    @Autowired
    private ApplicationDao applicationDao;


    public void saveApplication(Application application) {
        applicationDao.saveApplication(application);
    }

    public void saveApplicationBatch(List<Application> applications) {
        applicationDao.saveApplicationBatch(applications);
    }

    public void deleteApplication(int id) {
        applicationDao.deleteApplication(id);
    }

    public void deleteApplicationBatch(List<Integer> ids) {
        applicationDao.deleteApplicationBatch(ids);
    }

    public Application getApplication(int id) {
        return applicationDao.getApplication(id);
    }

    public List<Application> listApplicationsByCompanyId(Page page) {
        return applicationDao.listApplicationsByCompanyId(page);
    }

    public List<Application> listApplicationsByUserId(Page page) {
        return applicationDao.listApplicationsByUserId(page);

    }


    public List<Application> listApplications(Page page) {
        return applicationDao.listApplications(page);
    }

    public void updateApplication(Application application) {
        applicationDao.updateApplication(application);
    }
}
