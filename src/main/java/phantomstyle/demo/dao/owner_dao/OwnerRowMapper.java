package phantomstyle.demo.dao.owner_dao;


import org.springframework.jdbc.core.RowMapper;
import phantomstyle.demo.domain.Owner;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OwnerRowMapper implements RowMapper<Owner> {
    @Override
    public Owner mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Owner(resultSet.getLong("id"), resultSet.getLong("companyId"),
                resultSet.getString("firstName"), resultSet.getString("secondName"));
    }
}
