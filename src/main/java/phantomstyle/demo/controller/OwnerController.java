package phantomstyle.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import phantomstyle.demo.dao.owner_dao.OwnerDao;
import phantomstyle.demo.domain.Account;
import phantomstyle.demo.domain.Owner;
import phantomstyle.demo.service.AccountService;
import phantomstyle.demo.service.OwnerService;

import java.util.List;
@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @Autowired
    AccountService accountService;

    @GetMapping("/all")
    List<Owner> findAll() {
        return ownerService.getAll();
    }

    @GetMapping("/{id}")
    Owner findById(@PathVariable("id") Long id) {
        return ownerService.getById(id);
    }

    @PostMapping("/save")
    Owner save(@RequestBody Owner owner) {
        return ownerService.save(owner);
    }

    @GetMapping("/{id}/accounts")
    List<Account> findAccountsByOwnerId(@PathVariable("id") Long id) {
        return accountService.getAllByOwnerId(id);
    }
}
