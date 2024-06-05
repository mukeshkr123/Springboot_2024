package com.mukesh.firstjobApp.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompany(Company updatedCompany, Long id);
}
