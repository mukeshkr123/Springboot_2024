package com.mukesh.firstjobApp.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompany(Company updatedCompany, Long id);
    void createCompany(Company company);
    boolean deleteJobById(Long id);
    Company getCompanyById(Long id);
}
