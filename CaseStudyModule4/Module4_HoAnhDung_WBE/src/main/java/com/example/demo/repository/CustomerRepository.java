package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer  , Integer> {
    @Query(value = "select * " +
            "from customer c " +
            "where concat(c.customer_name,c.customer_gender ,c.customer_id_card,c.customer_phone,c.customer_email) like %?1%",
            nativeQuery = true)
    Page<Customer> findAllInputTex(String keyword, Pageable pageable);
}
