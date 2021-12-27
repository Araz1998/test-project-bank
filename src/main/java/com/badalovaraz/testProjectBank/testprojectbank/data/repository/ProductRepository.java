package com.badalovaraz.testProjectBank.testprojectbank.data.repository;

import com.badalovaraz.testProjectBank.testprojectbank.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
