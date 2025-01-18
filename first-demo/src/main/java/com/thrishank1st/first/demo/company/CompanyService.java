package com.thrishank1st.first.demo.company;



import java.util.List;

public interface CompanyService {
    List<Company> findAllComps();
    void createComp(Company company);

    Company getCompById(Long id);

    boolean deleteCompById(Long id);

    boolean updateComp(Long id, Company updatedComp);
}
