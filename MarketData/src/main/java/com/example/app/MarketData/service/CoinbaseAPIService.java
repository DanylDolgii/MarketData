package com.example.app.MarketData.service;

import com.example.app.MarketData.model.CryptoPrice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CoinbaseAPIService {
    @Value("https://api.coinbase.com\n") // Base URL for Coinbase API
    private String coinbaseUrl;

    private final RestTemplate restTemplate;

    @Value("MY_API_KEY_VALUE") // API key for Coinbase API
    private String apiKey;

    public CoinbaseAPIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<CryptoPrice> fetchCryptoPricesFromCoinbase() {
        String url = coinbaseUrl + "/v2/prices";

        // Set headers with API key for authentication
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Fetch cryptocurrency prices from Coinbase API
        ResponseEntity<CryptoPrice[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, CryptoPrice[].class);
        CryptoPrice[] cryptoPrices = response.getBody();

        return Arrays.asList(cryptoPrices);
    }

    public Double calculateAverageCryptoPrice(List<CryptoPrice> cryptoPrices) {
        // Calculate average price
        double totalPrice = cryptoPrices.stream()
                .mapToDouble(CryptoPrice::getAveragePrice)
                .sum();
        int totalPrices = cryptoPrices.size();
        return totalPrices > 0 ? totalPrice / totalPrices : 0.0;
    }
}
