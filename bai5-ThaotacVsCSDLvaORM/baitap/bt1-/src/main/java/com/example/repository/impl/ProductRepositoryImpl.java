package com.example.repository.impl;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public List<Product> showAllProduct() {
        Query typedQuery = BaseRepository.entityManager.createNativeQuery( "select * from product", Product.class );
        return typedQuery.getResultList();
    }

    @Override
    public void deleteProduct(Integer id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove( findProductById( id ) );
        entityTransaction.commit();
    }

    @Override
    public Product findProductById(Integer id) {
        return BaseRepository.entityManager.find( Product.class, id );
    }

    @Override
    public void saveProduct(String action, Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        switch (action) {
            case "edit":
                BaseRepository.entityManager.merge( product );
                break;
            case "create":
                BaseRepository.entityManager.persist( product );
                break;
        }
        entityTransaction.commit();
    }
}