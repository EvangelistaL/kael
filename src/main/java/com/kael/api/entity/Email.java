package com.kael.api.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

@Data
public class Email implements Serializable {

    @jakarta.validation.constraints.Email
    private String to;

    @NotBlank
    private String subject;

    private String filePathToAttach;

    private String body;

}
