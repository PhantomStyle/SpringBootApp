package phantomstyle.demo.dao.company_dao;

import org.springframework.jdbc.core.RowMapper;
import phantomstyle.demo.domain.Company;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyRowMapper implements RowMapper<Company> {

    @Override
    public Company mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Company(resultSet.getLong("id"), resultSet.getString("title"));
    }
}
