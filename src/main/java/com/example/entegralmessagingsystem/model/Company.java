package com.example.entegralmessagingsystem.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Builder
public class Company {
    @Id
    private final String id;
    private final String name;
    private final List<Employee> employees;
}