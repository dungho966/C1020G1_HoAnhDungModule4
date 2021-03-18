package com.example.demo.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId ;


    @Pattern(regexp = "^(KH-)\\d{4}$", message = "Code must be KH-XXXX")
    private String customerCode ;
    private String customerName ;
    private String customerBirthday ;
    private String customerGender ;

    @Pattern(regexp = "(^\\d{9}$)|(^\\d{12}$)", message = "ID Card is not valid")
    @NotNull(message = "CustomerIDCard can be null")
    private String customerIdCard;

    @Pattern(regexp = "(^(090)\\d{7}$)|(^(091)\\d{7}$)|(^(\\+\\(84\\) 90)\\d{7}$)|(^(\\+\\(84\\) 91)\\d{7}$)",
            message = "wrong Form Phone Number")

    @Pattern(regexp = "(^(090)\\d{7}$)|(^(091)\\d{7}$)|(^(\\+\\(84\\) 90)\\d{7}$)|(^(\\+\\(84\\) 91)\\d{7}$)", message = "Phone number is not valid")
    private String customerPhone ;
    @Email
    private String customerEmail ;
    private String customerAddress ;

    @ManyToOne
    @JoinColumn(name = "customer_type_id")
    private CustomerType customerType ;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract ;

    @OneToMany(targetEntity = Contract.class , mappedBy = "employee")
    private List<Contract> contractList ;

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public Contract getContract() {
        return contract;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Customer() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

//    @Override
//    public boolean supports(Class<?> aClass) {
//        return false;
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        Customer customer = (Customer) target ;
//        String customerIdCard = customer.getCustomerIdCard();
//        ValidationUtils.rejectIfEmpty(errors, "customerIdCard" , "customeridcard.empty");
//        if (!customerIdCard.matches("^\\d{9,12}$")){
//            errors.rejectValue("customerIdCard" , "customeridcard.length");
//        }
//    }
}
