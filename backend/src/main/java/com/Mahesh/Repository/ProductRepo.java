package com.Mahesh.Repository;

import com.Mahesh.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product , Integer> {
    @Query("SELECT p FROM Product p WHERE LOWER( p.name) LIKE lower(concat( '%' ,:keyword ,'%')) or LOWER( p.description) LIKE lower(concat( '%' ,:keyword ,'%')) or LOWER( p.brand) LIKE lower(concat( '%' ,:keyword ,'%')) or LOWER( p.category) LIKE lower(concat( '%' ,:keyword ,'%'))")
    List<Product> searchProducts(String keyword);
}
