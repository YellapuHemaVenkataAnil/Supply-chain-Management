package com.scm.service;

import com.scm.model.Shipment;
import com.scm.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentService {

    @Autowired
    private ShipmentRepository shipmentRepository;

    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    public Optional<Shipment> getShipmentById(Long id) {
        return shipmentRepository.findById(id);
    }

    public Optional<Shipment> getShipmentByTracking(String trackingNumber) {
        return shipmentRepository.findByTrackingNumber(trackingNumber);
    }

    public Optional<Shipment> getShipmentByOrderId(Long orderId) {
        return shipmentRepository.findByOrderId(orderId);
    }

    public Shipment createShipment(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    public Shipment updateShipment(Long id, Shipment shipmentDetails) {
        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipment not found with id: " + id));

        shipment.setStatus(shipmentDetails.getStatus());
        shipment.setCarrierName(shipmentDetails.getCarrierName());
        shipment.setCurrentLocation(shipmentDetails.getCurrentLocation());
        shipment.setShippedDate(shipmentDetails.getShippedDate());
        shipment.setEstimatedArrival(shipmentDetails.getEstimatedArrival());
        shipment.setActualArrival(shipmentDetails.getActualArrival());
        shipment.setOrigin(shipmentDetails.getOrigin());
        shipment.setDestination(shipmentDetails.getDestination());
        shipment.setNotes(shipmentDetails.getNotes());

        return shipmentRepository.save(shipment);
    }

    public Shipment updateStatus(Long id, Shipment.ShipmentStatus status) {
        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipment not found with id: " + id));
        shipment.setStatus(status);
        return shipmentRepository.save(shipment);
    }

    public void deleteShipment(Long id) {
        shipmentRepository.deleteById(id);
    }

    public List<Shipment> getShipmentsByStatus(Shipment.ShipmentStatus status) {
        return shipmentRepository.findByStatus(status);
    }
}