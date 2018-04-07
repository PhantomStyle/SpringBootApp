package phantomstyle.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phantomstyle.demo.dao.account_dao.AccountDao;
import phantomstyle.demo.domain.Account;

import java.util.List;

@Component
public class AccountService {
    @Autowired
    AccountDao accountDao;



    public Account save(Account account) {
        if (accountDao.getById(account.getId()) != null) {
            return accountDao.update(account);
        } else {
            return accountDao.insert(account);
        }
    }

    public Account getById(Long id) {
        return accountDao.getById(id);
    }

    public List<Account> getAll() {
        return accountDao.getAll();
    }

    public List<Account> getAllByOwnerId(Long ownerId) {
        return accountDao.getAllByOwnerId(ownerId);
    }
}
