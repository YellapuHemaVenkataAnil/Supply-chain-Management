package com.scm.repository;

import com.scm.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    List<Supplier> findByStatus(Supplier.SupplierStatus status);
    List<Supplier> findByNameContainingIgnoreCase(String name);
    boolean existsByEmail(String email);

    @Query("SELECT COUNT(s) FROM Supplier s WHERE s.status = 'ACTIVE'")
    long countActiveSuppliers();
}