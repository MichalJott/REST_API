package com.crud.tasks.trello.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class CompanyConfig {
    @Value("${info.company.name}")
    private String CompanyName;

    @Value("${info.company.email}")
    private String CompanyEmail;

    @Value("${info.company.phone}")
    private String CompanyPhone;
}
