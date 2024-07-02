package com.kael.internal.controller;

import com.kael.api.controller.EmailController;
import com.kael.api.entity.Email;
import com.kael.api.usecase.SendEmail;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@ConditionalOnSingleCandidate(EmailController.class)
public class DefaultEmailController implements EmailController{

    private final SendEmail sendEmail;

    @Override
    public void sendEmails(Set<Email> emails) {
        sendEmail.execute(emails);
    }
}
