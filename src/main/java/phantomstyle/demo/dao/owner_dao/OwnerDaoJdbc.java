package phantomstyle.demo.dao.owner_dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import phantomstyle.demo.domain.Owner;

import java.util.List;

@Component
public class OwnerDaoJdbc implements OwnerDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Owner getById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Owner WHERE id = ?", new OwnerRowMapper());
    }

    @Override
    public List<Owner> getAll() {
        return jdbcTemplate.query("SELECT * FROM Owner", new OwnerRowMapper());
    }

    @Override
    public List<Owner> getAllByCompanyId(Long companyId) {
        return jdbcTemplate.query("SELECT * FROM Owner WHERE companyId = ?",
                new OwnerRowMapper(), companyId);
    }

    @Override
    public Owner insert(Owner owner) {
        jdbcTemplate.update("INSERT INTO Owner(id, companyId, firstName, secondName) VALUES (?, ?, ?, ?)",
                owner.getId(), owner.getCompanyId(), owner.getFirstName(), owner.getSecondName());
        return owner;
    }

    @Override
    public Owner update(Owner owner) {
        jdbcTemplate.update("UPDATE Owner SET firstName = ?, secondName = ? WHERE id = ?",
                owner.getFirstName(), owner.getSecondName(), owner.getId());
        return owner;
    }
}
