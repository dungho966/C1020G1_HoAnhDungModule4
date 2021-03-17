package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.util.List;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int contractId ;
    private String contractStartDate ;
    private String contractEndDate ;

    @DecimalMin(value = "0.01", message = " Phải Là Số Dương")
    private String contractDeposit ;

    @DecimalMin(value = "0.01", message = "Phải Là Số Dương")
    private String contractTotalMoney ;

    @OneToMany(targetEntity = Customer.class, mappedBy = "contract")
    private List<Customer> customerList ;


    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee ;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer ;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service ;

    @OneToMany(targetEntity = ContractDetail.class,mappedBy = "contract")
    private List<ContractDetail> contractDetailList ;

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Contract() {
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(String contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public String getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(String contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
