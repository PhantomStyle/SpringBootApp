package phantomstyle.demo.dao.account_dao;

import phantomstyle.demo.domain.Account;

import java.util.List;

public interface AccountDao {
    Account getById(Long id);

    List<Account> getAll();

    List<Account> getAllByOwnerId(Long ownerId);

    Account insert(Account account);

    Account update(Account account);
}
