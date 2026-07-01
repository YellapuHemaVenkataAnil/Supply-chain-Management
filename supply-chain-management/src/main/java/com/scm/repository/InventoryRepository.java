package com.scm.repository;

import com.scm.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryItem, Long> {
    Optional<InventoryItem> findBySku(String sku);
    List<InventoryItem> findByStatus(InventoryItem.ItemStatus status);
    List<InventoryItem> findByCategory(String category);
    List<InventoryItem> findByNameContainingIgnoreCase(String name);
    List<InventoryItem> findBySupplierId(Long supplierId);

    @Query("SELECT i FROM InventoryItem i WHERE i.quantity <= i.minQuantity")
    List<InventoryItem> findLowStockItems();

    @Query("SELECT COUNT(i) FROM InventoryItem i WHERE i.status = 'OUT_OF_STOCK'")
    long countOutOfStockItems();

    @Query("SELECT COUNT(i) FROM InventoryItem i WHERE i.status = 'LOW_STOCK'")
    long countLowStockItems();
}