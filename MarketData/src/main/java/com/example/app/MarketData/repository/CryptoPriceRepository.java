package com.example.app.MarketData.repository;

import com.example.app.MarketData.model.CryptoPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptoPriceRepository extends JpaRepository<CryptoPrice, Long> {
}
