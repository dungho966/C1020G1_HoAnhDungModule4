package com.example.demo.repository;

import com.example.demo.model.Contract;
import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract , Integer> {
    @Query(value = "select * " +
            "from contract c " +
            "where concat(c.contract_id,c.contract_deposit ,c.contract_end_date,c.contract_start_date,c.contract_total_money) like %?1%",
            nativeQuery = true)
    Page<Contract> findAllInputTex(String keyword, Pageable pageable);
}
