package phantomstyle.demo.dao.company_dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import phantomstyle.demo.domain.Company;

import java.util.List;

@Component
public class CompanyDaoJdbc implements CompanyDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Company getById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Company WHERE id = ?", new CompanyRowMapper());
    }

    @Override
    public List<Company> getAll() {
        return jdbcTemplate.query("SELECT * FROM Company", new CompanyRowMapper());
    }

    @Override
    public Company insert(Company company) {
        jdbcTemplate.update("INSERT INTO Company(id, title) VALUES (?, ?)", company.getId(), company.getTitle());
        return company;
    }

    @Override
    public Company update(Company company) {
        jdbcTemplate.update("UPDATE Company SET title = ? WHERE id = ?", company.getTitle(), company.getId());
        return company;
    }
}
