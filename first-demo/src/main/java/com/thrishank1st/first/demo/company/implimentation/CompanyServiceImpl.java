package com.thrishank1st.first.demo.company.implimentation;

import com.thrishank1st.first.demo.company.Company;
import com.thrishank1st.first.demo.company.CompanyRepository;
import com.thrishank1st.first.demo.company.CompanyService;
import com.thrishank1st.first.demo.job.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAllComps() {
        return companyRepository.findAll();
    }

    @Override
    public void createComp(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company getCompById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCompById(Long id) {
        if(companyRepository.existsById(id)){
            companyRepository.deleteById(id);
            return true;
        } else  {
            return false;
        }
    }

    @Override
    public boolean updateComp(Long id, Company updatedComp) {
        Optional<Company> companyOptional = companyRepository.findById(id);

        if (companyOptional.isPresent()){
            Company company = companyOptional.get();
            company.setName(updatedComp.getName());
            company.setDescription(updatedComp.getDescription());
            company.setJobs(updatedComp.getJobs());
            companyRepository.save(company);
            return true;
        }

        return false;
    }

}
