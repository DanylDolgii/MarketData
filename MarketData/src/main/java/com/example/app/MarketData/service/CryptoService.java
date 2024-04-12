package com.example.app.MarketData.service;



import com.example.app.MarketData.model.CryptoPrice;
import com.example.app.MarketData.repository.CryptoPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CryptoService {
    private final CryptoPriceRepository cryptoPriceRepository;

    @Autowired
    public CryptoService(CryptoPriceRepository cryptoPriceRepository) {
        this.cryptoPriceRepository = cryptoPriceRepository;
    }
    public List<CryptoPrice> getAllCryptoPrices() {
        return cryptoPriceRepository.findAll();
    }

    public CryptoPrice saveCryptoPrice(CryptoPrice cryptoPrice) {
        return cryptoPriceRepository.save(cryptoPrice);
    }

    public CryptoPrice getCryptoPriceById(Long id) {
        return cryptoPriceRepository.findById(id).orElse(null);
    }

    public void deleteCryptoPriceById(Long id) {
        cryptoPriceRepository.deleteById(id);
    }
}
