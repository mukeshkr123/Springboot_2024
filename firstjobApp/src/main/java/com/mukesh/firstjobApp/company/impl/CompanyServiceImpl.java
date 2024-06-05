package com.mukesh.firstjobApp.company.impl;

import com.mukesh.firstjobApp.company.Company;
import com.mukesh.firstjobApp.company.CompanyRepository;
import com.mukesh.firstjobApp.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public boolean updateCompany(Company updatedCompany, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company company = companyOptional.get();
            company.setName(updatedCompany.getName());
            company.setDescription(updatedCompany.getDescription());
            companyRepository.save(company);
            return  true;
        }
        return  false;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean deleteJobById(Long id){
        if(companyRepository.existsById(id)){
            companyRepository.deleteById(id);
        }
        return false;
    }

    @Override
    public Company getCompanyById(Long id){
      return  companyRepository.findById(id).orElse(null);
    }

}
