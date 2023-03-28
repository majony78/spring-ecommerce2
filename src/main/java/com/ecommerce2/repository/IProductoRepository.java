package com.ecommerce2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce2.model.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> {
	
	

}
