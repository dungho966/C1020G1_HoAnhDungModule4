package com.example.demo.model;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

@Component
public class User implements Validator {
    private String firstName ;
    private String lastName ;
    private String number ;

    @Min(value = 18 , message = "Tuoi phai lon hon 18")
    private String age ;

    @Email(message = "Email Khong Hop Le")
    private String email ;

    public User() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User(String firstName, String number , String lastName, String age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number ;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target ;
        String firstName = user.getFirstName();
        ValidationUtils.rejectIfEmpty(errors , "firstName" , "firstname.empty");
        if (firstName.length() < 5 || firstName.length() > 45 ){
            errors.rejectValue("firstName" , "firstname.length");
        }



        String lastname = user.getLastName();
        ValidationUtils.rejectIfEmpty(errors , "lastName" , "lastname.empty");
        if (lastname.length() < 5 || lastname.length() > 45 ){
            errors.rejectValue("lastName" , "lastname.length");
        }

        String number = user.getNumber();
        ValidationUtils.rejectIfEmpty(errors, "number", "number.empty");
        if (number.length()>11 || number.length()<10){
            errors.rejectValue("number", "number.length");
        }
        if (!number.startsWith("0")){
            errors.rejectValue("number", "number.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("number", "number.matches");
        }

    }
}
