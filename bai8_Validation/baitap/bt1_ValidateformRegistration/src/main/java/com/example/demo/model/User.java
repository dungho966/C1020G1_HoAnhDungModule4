package com.example.demo.model;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class User implements Validator {
    private String firstName ;
    private String lastname ;
    private String number ;
    private String age ;
    private String email ;

    public User() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User(String firstName, String number , String lastname, String age, String email) {
        this.firstName = firstName;
        this.lastname = lastname;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
        ValidationUtils.rejectIfEmpty(errors , "firstname" , "firstname.empty");
        if (firstName.length() < 5 || firstName.length() > 45 ){
            errors.rejectValue("firstname" , "firstname.length");
        }



        String lastname = user.getLastname();
        ValidationUtils.rejectIfEmpty(errors , "lastname" , "lastname.empty");
        if (lastname.length() < 5 || lastname.length() > 45 ){
            errors.rejectValue("lastname" , "lastname.length");
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

        String age = user.getAge();
        ValidationUtils.rejectIfEmpty(errors , "age" , "age.empty");
        if (age.length() <18 ){
            errors.rejectValue("age" , "age.length");
        }

        String email = user.getEmail() ;
        ValidationUtils.rejectIfEmpty(errors , "email" , "email.empty");
        if (!email.matches("\"^[a-z]+@[a-z]+([.][a-z]{2,})+$\"")){
            errors.rejectValue("email" , "email.matches");
        }
    }
}
