package com.mukesh.firstjobApp.company.impl;

import com.mukesh.firstjobApp.company.Company;
import com.mukesh.firstjobApp.company.CompanyRepository;
import com.mukesh.firstjobApp.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return  companyRepository.findAll();
    }
}
