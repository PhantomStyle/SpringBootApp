package phantomstyle.demo.dao.owner_dao;

import phantomstyle.demo.domain.Owner;

import java.util.List;

public interface OwnerDao {
    Owner getById(Long id);

    List<Owner> getAll();

    List<Owner> getAllByCompanyId(Long companyId);

    Owner insert(Owner owner);

    Owner update(Owner owner);
}
