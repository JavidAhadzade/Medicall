package com.example.medicall.Service;

import com.example.medicall.Dto.DoctorData;
import com.example.medicall.Entity.Doctor;
import com.example.medicall.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.transaction.Transactional;

@Service
@Transactional
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    public void setDoctorRepository(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor findByUsername(String name){
        return  doctorRepository.findByEmail(name);
    }
    public void updatePassword(Doctor doctor,String password){
        BCryptPasswordEncoder bc=new BCryptPasswordEncoder();
        String encodePassword=bc.encode(password);
        doctor.setPassword(encodePassword);
        doctorRepository.save(doctor);
    }
    public void saveUserRegister(DoctorData doctorData) throws MessagingException {
        if (emailExists(doctorData.getEmail())) {
            throw new MessagingException("There is an account with that email address: "
                    + doctorData.getEmail());
        }
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        String encodePassword = bc.encode(doctorData.getPassword());
        Doctor newUser = new Doctor();
        newUser.setName(doctorData.getName());
        newUser.setSurname(doctorData.getSurname());
        newUser.setEmail(doctorData.getEmail());
        newUser.setPassword(encodePassword);

        doctorRepository.saveAndFlush(newUser);
    }
    private boolean emailExists(String email) {
        return doctorRepository.findByEmail(email) != null;
    }

}
