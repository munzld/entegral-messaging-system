package com.example.entegralmessagingsystem.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class Employee {
    @Id
    private final String id;
    private final String firstName;
    private final String lastName;
    private final EmployeeType employeeType;
    private final CommunicationType communicationType;
    private final String phoneNumber;
    private final String email;
}
