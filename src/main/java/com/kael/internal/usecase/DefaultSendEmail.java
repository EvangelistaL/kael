package com.kael.internal.usecase;

import com.kael.api.entity.Email;
import com.kael.api.usecase.SendEmail;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Objects;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class DefaultSendEmail implements SendEmail {

    private static final String FROM_EMAIL = "noreply@email.com";

    private final JavaMailSender javaMailSender;

    @Override
    public void execute(Set<Email> emails) {
        emails.forEach(this::sendEmail);
    }

    private void sendEmail(Email email){
        MimeMessage message = javaMailSender.createMimeMessage();
        FileSystemResource file = getAttachment(email.getFilePathToAttach());
        buildingEmail(email, message, file);
        javaMailSender.send(message);
    }

    private FileSystemResource getAttachment(String filePath){
        FileSystemResource file = new FileSystemResource(new File(filePath));
        if (file.exists()){
            return file;
        }
        log.warn("File not found with path: {}", filePath);
        return null;
    }

    private void buildingEmail(Email email,
                               MimeMessage message,
                               FileSystemResource file){
        try{
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(FROM_EMAIL);
            helper.setTo(email.getTo());
            helper.setSubject(email.getSubject());
            helper.setText(email.getBody());
            if (file != null){
                helper.addAttachment(Objects.requireNonNull(file.getFilename()), file);
            }
        } catch (MessagingException e){
            log.error(e.getMessage());
        }
    }
}
