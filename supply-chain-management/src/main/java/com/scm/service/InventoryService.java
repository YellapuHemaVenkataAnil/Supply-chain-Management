package com.scm.service;

import com.scm.model.InventoryItem;
import com.scm.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<InventoryItem> getAllItems() {
        return inventoryRepository.findAll();
    }

    public Optional<InventoryItem> getItemById(Long id) {
        return inventoryRepository.findById(id);
    }

    public InventoryItem createItem(InventoryItem item) {
        return inventoryRepository.save(item);
    }

    public InventoryItem updateItem(Long id, InventoryItem itemDetails) {
        InventoryItem item = inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory item not found with id: " + id));

        item.setName(itemDetails.getName());
        item.setSku(itemDetails.getSku());
        item.setDescription(itemDetails.getDescription());
        item.setCategory(itemDetails.getCategory());
        item.setQuantity(itemDetails.getQuantity());
        item.setMinQuantity(itemDetails.getMinQuantity());
        item.setPrice(itemDetails.getPrice());
        item.setUnit(itemDetails.getUnit());
        item.setWarehouse(itemDetails.getWarehouse());
        item.setSupplier(itemDetails.getSupplier());

        return inventoryRepository.save(item);
    }

    public InventoryItem updateStock(Long id, int quantity) {
        InventoryItem item = inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory item not found with id: " + id));
        item.setQuantity(quantity);
        return inventoryRepository.save(item);
    }

    public void deleteItem(Long id) {
        inventoryRepository.deleteById(id);
    }

    public List<InventoryItem> getLowStockItems() {
        return inventoryRepository.findLowStockItems();
    }

    public List<InventoryItem> getItemsByCategory(String category) {
        return inventoryRepository.findByCategory(category);
    }

    public List<InventoryItem> searchItems(String name) {
        return inventoryRepository.findByNameContainingIgnoreCase(name);
    }

    public long countOutOfStockItems() {
        return inventoryRepository.countOutOfStockItems();
    }

    public long countLowStockItems() {
        return inventoryRepository.countLowStockItems();
    }
}