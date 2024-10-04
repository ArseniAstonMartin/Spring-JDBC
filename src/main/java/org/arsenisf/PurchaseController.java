package org.arsenisf;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PurchaseController {
    private final PurchaseRepository purchaseRepository;

    @GetMapping("/purchase")
    public ResponseEntity<List<Purchase>> getPurchases () {
        return ResponseEntity.ok(purchaseRepository.selectAll());
    }

    @PostMapping("/purchase")
    public void addPurchase(@RequestBody Purchase purchase) {
        purchaseRepository.addPurchase(purchase);
    }

    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }
}
