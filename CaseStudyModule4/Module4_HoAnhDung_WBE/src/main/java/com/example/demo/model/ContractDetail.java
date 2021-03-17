package com.example.demo.model;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int contractDetailId ;
    private String quantity ;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract ;

    @ManyToOne
    @JoinColumn(name = "attackservice_id")
    private AttackService attackService ;

    public ContractDetail() {
    }

    public int getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(int contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttackService getAttackService() {
        return attackService;
    }

    public void setAttackService(AttackService attackService) {
        this.attackService = attackService;
    }
}
