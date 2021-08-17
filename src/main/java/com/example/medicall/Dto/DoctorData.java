package com.example.medicall.Dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.validation.constraints.Size;

public class DoctorData {
    @NotEmpty(message = "Zəhmət olmasa adınızı daxil edin")
    @Size(min = 2 , max = 50 , message = "Adınız minimum 2 və maksimum 50 hərfdən ibarət ola bilər")
    String name;
    @NotEmpty(message = "Zəhmət olmasa soyadınızı daxil edin")
    @Size(min = 2 , max = 50 , message = "Soyadınız minimum 2 və maksimum 50 hərfdən ibarət ola bilər")
    String surname;
    @NotEmpty(message = "Zəhmət olmasa e-mail ünvanını daxil edin")
    @Email(message = "Düzgün e-mail formatı daxil etdiyinizdən əmin olun")
    String email;
    @NotEmpty(message = "Zəhmət olmasa parolunuzu  daxil edin")
    String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
