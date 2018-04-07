package phantomstyle.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import phantomstyle.demo.dao.company_dao.CompanyDao;
import phantomstyle.demo.domain.Company;
import phantomstyle.demo.domain.Owner;
import phantomstyle.demo.service.CompanyService;
import phantomstyle.demo.service.OwnerService;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @Autowired
    OwnerService ownerService;

    @GetMapping("/all")
    List<Company> findAll() {
        return companyService.getAll();
    }

    @GetMapping("/{id}")
    Company findById(@PathVariable("id") Long id) {
        return companyService.getById(id);
    }

    @PostMapping("/save")
    Company save(@RequestBody Company company) {
        return companyService.save(company);
    }

    @GetMapping("/{id}/owners")
    List<Owner> findOwnersByCompanyId(@PathVariable("id") Long id) {
        return ownerService.getAllByCompanyId(id);
    }
}
