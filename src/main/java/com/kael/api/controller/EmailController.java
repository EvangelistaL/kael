package com.kael.api.controller;

import com.kael.api.entity.Email;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(path = "/api/send-email")
public interface EmailController {

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    void sendEmails(@RequestBody @Valid Set<Email> emails);
}
