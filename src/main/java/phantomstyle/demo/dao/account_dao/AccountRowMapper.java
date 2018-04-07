package phantomstyle.demo.dao.account_dao;


import org.springframework.jdbc.core.RowMapper;
import phantomstyle.demo.domain.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Account(rs.getLong("id"), rs.getLong("ownerId"),
                rs.getString("name"), rs.getDouble("rate"));
    }
}
