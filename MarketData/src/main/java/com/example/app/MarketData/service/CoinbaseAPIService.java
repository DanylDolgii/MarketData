package com.example.app.MarketData.service;

import com.example.app.MarketData.model.CryptoPrice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CoinbaseAPIService {
    @Value("${coinbase.api.url}")
    private String coinbaseUrl;

    private final RestTemplate restTemplate;

    public CoinbaseAPIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Double calculateAverageCryptoPrice() {
        // Fetch cryptocurrency prices from Coinbase API
        CryptoPrice[] cryptoPrices = restTemplate.getForObject(coinbaseUrl, CryptoPrice[].class);

        // Calculate average price
        double totalPrice = Arrays.stream(cryptoPrices)
                .mapToDouble(CryptoPrice::getAveragePrice)
                .sum();
        int totalPrices = cryptoPrices.length;
        double averagePrice = totalPrices > 0 ? totalPrice / totalPrices : 0.0;

        return averagePrice;
    }
}
