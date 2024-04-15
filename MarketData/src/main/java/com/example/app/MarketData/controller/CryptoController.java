package com.example.app.MarketData.controller;

import com.example.app.MarketData.model.CryptoPrice;
import com.example.app.MarketData.service.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crypto")
public class CryptoController {

    private final CryptoService cryptoService;

    @Autowired
    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping("/prices")
    public List<CryptoPrice> getAllCryptoPrices() {
        return cryptoService.getAllCryptoPrices();
    }

    @GetMapping("/prices/{id}")
    public CryptoPrice getCryptoPriceById(@PathVariable Long id) {
        return cryptoService.getCryptoPriceById(id);
    }

    @PostMapping("/prices")
    public CryptoPrice createCryptoPrice(@RequestBody CryptoPrice cryptoPrice) {
        return cryptoService.saveCryptoPrice(cryptoPrice);
    }

    @PutMapping("/prices/{id}")
    public CryptoPrice updateCryptoPrice(@PathVariable Long id, @RequestBody CryptoPrice cryptoPrice) {
        cryptoPrice.setId(id);
        return cryptoService.saveCryptoPrice(cryptoPrice);
    }

    @DeleteMapping("/prices/{id}")
    public void deleteCryptoPrice(@PathVariable Long id) {
        cryptoService.deleteCryptoPriceById(id);
    }
}
