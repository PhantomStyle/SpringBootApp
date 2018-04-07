package phantomstyle.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phantomstyle.demo.dao.owner_dao.OwnerDao;
import phantomstyle.demo.domain.Owner;

import java.util.List;

@Component
public class OwnerService {
    @Autowired
    OwnerDao ownerDao;

    public Owner save(Owner owner) {
        if (ownerDao.getById(owner.getId()) != null) {
            return ownerDao.update(owner);
        } else {
            return ownerDao.insert(owner);
        }
    }

    public Owner getById(Long id) {
        return ownerDao.getById(id);
    }

    public List<Owner> getAll() {
        return ownerDao.getAll();
    }

    public List<Owner> getAllByCompanyId(Long companyId) {
        return ownerDao.getAllByCompanyId(companyId);
    }
}
