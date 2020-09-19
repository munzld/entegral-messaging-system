package com.example.entegralmessagingsystem.repository;

import com.example.entegralmessagingsystem.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<Company, String> {
    Company findByName(String name);
}
