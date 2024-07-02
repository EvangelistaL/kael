package com.kael.api.usecase;

import com.kael.api.entity.Email;

import java.util.Set;

public interface SendEmail {

    void execute(Set<Email> emails);
}
