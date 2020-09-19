package com.example.entegralmessagingsystem.model.message;

import com.example.entegralmessagingsystem.model.ProcessType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Message {
    private final String text;
    private final String subject;
    private final ProcessType processType;
}
