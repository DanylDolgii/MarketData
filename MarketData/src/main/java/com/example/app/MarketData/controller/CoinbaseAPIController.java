package com.example.app.MarketData.controller;

import com.example.app.MarketData.model.CryptoPrice;
import com.example.app.MarketData.repository.CryptoPriceRepository;
import com.example.app.MarketData.service.CoinbaseAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/crypto")
public class CoinbaseAPIController {

    private final CoinbaseAPIService coinbaseAPIService;
    private final CryptoPriceRepository cryptoPriceRepository;

    @Autowired
    public CoinbaseAPIController(CoinbaseAPIService coinbaseAPIService, CryptoPriceRepository cryptoPriceRepository) {
        this.coinbaseAPIService = coinbaseAPIService;
        this.cryptoPriceRepository = cryptoPriceRepository;
    }

    @GetMapping("/average")
    public Double getAverageCryptoPriceAndSave() {
        // Fetch cryptocurrency prices from Coinbase API
        List<CryptoPrice> cryptoPrices = coinbaseAPIService.fetchCryptoPricesFromCoinbase();

        // Calculate average cryptocurrency price
        Double averagePrice = coinbaseAPIService.calculateAverageCryptoPrice(cryptoPrices);

        // Save the fetched data to the database
        cryptoPriceRepository.saveAll(cryptoPrices);

        return averagePrice;
    }
}
