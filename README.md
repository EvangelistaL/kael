# Kael email sender 📧

Kael is an API for sending emails, built with Java 17 and the Spring boot 3.

## Installation

Use the package manager [maven](https://maven.apache.org/what-is-maven.html) to build the project.

```bash
mvn clean install
```

## Set the environment variables with your SMTP server config

```bash
export EMAIL_HOST= #your.smtp.email.host

export EMAIL_PORT= #smtp server port

export EMAIL_USERNAME= #your email username

export EMAIL_PASSWORD= #your email password
```

## Import this HTTP request
```
curl --location 'localhost:8080/api/send-email' \
--header 'Content-Type: application/json' \
--data-raw '[
    {
        "to": "test@gmail.com",
        "subject": "test",
        "filePathToAttach": "C:/file-path",
        "body": "Test",
        "archiveIsOnWSL": false
    }
]'
```
