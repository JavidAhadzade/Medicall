package com.example.medicall.Controller;

import com.example.medicall.Dto.DoctorData;
import com.example.medicall.Entity.Doctor;
import com.example.medicall.Repository.DoctorRepository;
import com.example.medicall.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RegistrationController {
    @Autowired
    DoctorService doctorService;
    @Autowired
    DoctorRepository doctorRepository;
    @GetMapping("/signUp")
    public String signUpWithEmailPage( Model model) {
        model.addAttribute("title", "Qeydiyyat");
        model.addAttribute("doctor",new DoctorData());
        return "registration";
    }
    @RequestMapping(value="/signUp", method= RequestMethod.POST)
    public Object registerUser(@Valid @ModelAttribute("doctor") DoctorData doctorData, Model model, BindingResult result
            , HttpServletRequest request)throws MessagingException {
        String password = doctorData.getPassword();
        Doctor existingDoctor = doctorRepository.findByEmail(doctorData.getEmail());
        if (existingDoctor != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            return "registration";
        }
        System.out.println("Controller");
        doctorService.saveUserRegister(doctorData);
        return "registration";
    }
}
