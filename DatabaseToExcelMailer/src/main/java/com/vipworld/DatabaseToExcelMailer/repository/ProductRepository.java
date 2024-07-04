package com.vipworld.DatabaseToExcelMailer.repository;
import com.vipworld.DatabaseToExcelMailer.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductRepository extends JpaRepository<Product,String> {
}
