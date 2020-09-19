package com.example.entegralmessagingsystem.service;

import com.example.entegralmessagingsystem.model.CommunicationType;
import com.example.entegralmessagingsystem.model.Company;
import com.example.entegralmessagingsystem.model.Employee;
import com.example.entegralmessagingsystem.model.message.Message;
import com.example.entegralmessagingsystem.repository.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    private static final Logger LOG = LoggerFactory.getLogger(MessageService.class);

    private final CompanyRepository companyRepository;
    private final EmailService emailService;

    public MessageService(CompanyRepository companyRepository, EmailService emailService) {
        this.companyRepository = companyRepository;
        this.emailService = emailService;
    }

    public void sendMessageToCompany(String companyId, Message message) {
        Optional<Company> company = retrieveCompany(companyId);
        company.ifPresent(c -> LOG.debug("Company retrieved: {}", c));
        company.ifPresent(value -> sendMessageToCompanyEmployees(value, message));
    }

    public void sendMessageToAllCompanies(Message message) {
        List<Company> companies = retrieveAllCompanies();
        LOG.debug("Companies retrieved: {}", companies);
    }

    private void sendMessageToCompanyEmployees(Company company, Message message) {
        for(Employee employee : company.getEmployees()) {
            if(CommunicationType.EMAIL.equals(employee.getCommunicationType())) {
                this.emailService.sendSimpleMessage(employee.getEmail(), message.getSubject(), message.getText());
            }
        }
    }

    private List<Company> retrieveAllCompanies() {
        return companyRepository.findAll();
    }

    private Optional<Company> retrieveCompany(String companyId) {
        return companyRepository.findById(companyId);
    }
}
