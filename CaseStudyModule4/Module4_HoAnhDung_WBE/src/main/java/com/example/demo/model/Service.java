package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class Service {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int serviceId ;

    @Pattern(regexp = "^(DV-)\\d{4}$", message = "Code must be DV-XXXX")
    private String serviceCode ;

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    private String serviceName ;

    @DecimalMin(value = "0.01", message = "Phải Là Số Dương")
    private String useArea ;

    @DecimalMin(value = "0.01", message = "Phải Là Số Dương")
    private String serviceCost ;


    @DecimalMin(value = "0.01", message = "Phải Là Số Dương")
    private String serviceMaxPeople ;
    private String standardRoom ;
    private String descriptionOtherConvenience ;

    @DecimalMin(value = "0.01", message = "Phải Là Số Dương")
    private String poolArea ;

    @DecimalMin(value = "0.01", message = "Phải Là Số Dương")
    private String numberOfFloor ;

    @ManyToOne
    @JoinColumn(name = "renttype_id")
    private RentType rentType ;
    @ManyToOne
    @JoinColumn(name = "service_type_id")
    private ServiceType serviceType ;

    @OneToMany(targetEntity = Contract.class , mappedBy = "employee")
    private List<Contract> contractList ;

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Service() {
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getUseArea() {
        return useArea;
    }

    public void setUseArea(String useArea) {
        this.useArea = useArea;
    }

    public String getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(String serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(String serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(String numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

}
