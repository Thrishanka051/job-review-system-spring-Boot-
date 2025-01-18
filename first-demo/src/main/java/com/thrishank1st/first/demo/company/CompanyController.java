package com.thrishank1st.first.demo.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comps")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) { // for help spring
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAll(){
        return new ResponseEntity<>(companyService.findAllComps(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createComp(@RequestBody Company company){
        companyService.createComp(company);
        return new ResponseEntity<>("company added", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateComp(@PathVariable Long id, @RequestBody Company company){
        companyService.updateComp(id,company);
        return new ResponseEntity<>("update success",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComp(@PathVariable Long id){
        boolean deleted = companyService.deleteCompById(id);
        if (deleted)
            return new ResponseEntity<>("successfully deleted",HttpStatus.OK);
        else
            return new ResponseEntity<>("company not found",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompById(@PathVariable Long id){
        if(companyService.getCompById(id) == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(companyService.getCompById(id),HttpStatus.OK);
    }

}
