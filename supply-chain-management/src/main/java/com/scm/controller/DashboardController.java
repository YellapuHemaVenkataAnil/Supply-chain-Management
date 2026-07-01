package com.scm.controller;

import com.scm.service.InventoryService;
import com.scm.service.OrderService;
import com.scm.service.ShipmentService;
import com.scm.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {

    @Autowired private SupplierService supplierService;
    @Autowired private InventoryService inventoryService;
    @Autowired private OrderService orderService;
    @Autowired private ShipmentService shipmentService;

    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> getDashboardStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("totalSuppliers", supplierService.countActiveSuppliers());
        stats.put("totalItems", inventoryService.getAllItems().size());
        stats.put("lowStockItems", inventoryService.countLowStockItems());
        stats.put("outOfStockItems", inventoryService.countOutOfStockItems());
        stats.put("pendingOrders", orderService.countPendingOrders());
        stats.put("totalOrders", orderService.getAllOrders().size());
        stats.put("totalRevenue", orderService.getTotalRevenue());
        stats.put("totalShipments", shipmentService.getAllShipments().size());
        return ResponseEntity.ok(stats);
    }
}