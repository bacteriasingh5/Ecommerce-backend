package com.example.ecomerce.dao;

import com.example.ecomerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Repository for Product entity with CORS support.
 */
@CrossOrigin(origins = "http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Find products by category ID with pagination.
     * @param id The category ID.
     * @param pageable Pagination details.
     * @return A page of products.
     */

    Page<Product> findByCategoryId(@Param("id") Long id, @PageableDefault(size = 50, sort = "name", direction = Sort.Direction.ASC) Pageable pageable);

    Page<Product> findByNameContainingIgnoreCase(@Param("name") String name,  Pageable pageable);


}
