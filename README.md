# Kael email sender 📧

Kael is an API for sending emails, built with Java 17 and the Spring boot 3.

## Installation

Use the package manager [maven](https://maven.apache.org/what-is-maven.html) to build the project.

```bash
mvn clean install
```

## Set the environment variables with your SMTP server config

```bash
export EMAIL_HOST= #your.smpt.email.host

export EMAIL_PORT= #smtp port

export EMAIL_USERNAME= #your email username

export EMAIL_PASSWORD= #your email password
```

## Import this HTTP request
```
curl --location 'localhost:8080/api/send-email' \
--header 'Content-Type: application/json' \
--data-raw '[
    {
        "to": "lukasevangelistasna@gmail.com",
        "subject": "teste",
        "filePathToAttach": "C:/Users/Lucas/Downloads/cv-lucas-evangelista.pdf",
        "body": "Teste"
    }
]'
```
