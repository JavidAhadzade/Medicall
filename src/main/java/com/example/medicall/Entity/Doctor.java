package com.example.medicall.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    Long id;
    @NotEmpty(message = "Zəhmət olmasa adınızı daxil edin")
    @Size(min = 2 , max = 50 , message = "Adınız minimum 2 və maksimum 50 hərfdən ibarət ola bilər")
    @Column(name = "Ad")
    String name;
    @NotEmpty(message = "Zəhmət olmasa soyadınızı daxil edin")
    @Size(min = 2 , max = 50 , message = "Soyadınız minimum 2 və maksimum 50 hərfdən ibarət ola bilər")
    @Column(name = "Soyad")
    String surname;
    @NotEmpty(message = "Zəhmət olmasa e-mail ünvanını daxil edin")
    @Email(message = "Düzgün e-mail formatı daxil etdiyinizdən əmin olun")
    @Column(name = "E-mail")
    String email;
    @NotEmpty(message = "Zəhmət olmasa parolunuzu  daxil edin")
    @Column(name = "Parol")
    String password;

}
