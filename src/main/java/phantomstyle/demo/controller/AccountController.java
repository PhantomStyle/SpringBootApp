package phantomstyle.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import phantomstyle.demo.dao.account_dao.AccountDao;
import phantomstyle.demo.domain.Account;
import phantomstyle.demo.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/all")
    List<Account> findAll() {
        return accountService.getAll();
    }

    @GetMapping("/{id}")
    Account findById(@PathVariable("id") Long id) {
        return accountService.getById(id);
    }

    @PostMapping("/save")
    Account save(@RequestBody Account person) {
        return accountService.save(person);
    }
}
