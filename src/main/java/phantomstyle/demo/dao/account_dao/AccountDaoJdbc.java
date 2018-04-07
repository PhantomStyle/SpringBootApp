package phantomstyle.demo.dao.account_dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import phantomstyle.demo.domain.Account;

import java.util.List;

@Component
public class AccountDaoJdbc implements AccountDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Account getById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Account WHERE id = ?", new AccountRowMapper());
    }

    @Override
    public List<Account> getAll() {
        return jdbcTemplate.query("SELECT * FROM Account", new AccountRowMapper());
    }

    @Override
    public List<Account> getAllByOwnerId(Long ownerId) {
        return jdbcTemplate.query("SELECT * FROM Account WHERE ownerId = ?",
                new AccountRowMapper(), ownerId);
    }

    @Override
    public Account insert(Account account) {
        jdbcTemplate.update("INSERT INTO Account(id, ownerId, name, rate) VALUES (?, ?, ?, ?)",
                account.getId(), account.getOwnerId(), account.getName(), account.getRate());
        return account;
    }

    @Override
    public Account update(Account account) {
        jdbcTemplate.update("UPDATE Company SET name = ?, rate = ? WHERE id = ?",
                account.getName(), account.getRate(), account.getId());
        return account;
    }
}
