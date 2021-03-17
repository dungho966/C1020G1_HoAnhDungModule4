package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class AttackService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int attackServiceID ;
    private String attackServiceName ;
    private String attackServiceCost ;
    private String attackServiceUnit ;
    private String attackServiceStatus ;

    @OneToMany(targetEntity = ContractDetail.class,mappedBy = "attackService")
    private List<ContractDetail> contractDetailList ;

    public AttackService() {
    }

    public int getAttackServiceID() {
        return attackServiceID;
    }

    public void setAttackServiceID(int attackServiceID) {
        this.attackServiceID = attackServiceID;
    }

    public String getAttackServiceName() {
        return attackServiceName;
    }

    public void setAttackServiceName(String attackServiceName) {
        this.attackServiceName = attackServiceName;
    }

    public String getAttackServiceCost() {
        return attackServiceCost;
    }

    public void setAttackServiceCost(String attackServiceCost) {
        this.attackServiceCost = attackServiceCost;
    }

    public String getAttackServiceUnit() {
        return attackServiceUnit;
    }

    public void setAttackServiceUnit(String attackServiceUnit) {
        this.attackServiceUnit = attackServiceUnit;
    }

    public String getAttackServiceStatus() {
        return attackServiceStatus;
    }

    public void setAttackServiceStatus(String attackServiceStatus) {
        this.attackServiceStatus = attackServiceStatus;
    }

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }
}
