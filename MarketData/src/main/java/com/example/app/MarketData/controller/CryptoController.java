//package com.example.app.MarketData.controller;
//
//
//import com.example.app.MarketData.model.CryptoPrice;
//import com.example.app.MarketData.service.CryptoService;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/crypto")
//public class CryptoController {
//    private final CryptoService cryptoService;
//
//    public CryptoController(CryptoService cryptoService) {
//        this.cryptoService = cryptoService;
//    }
//
//    @GetMapping("/average")
//    public List<CryptoPrice> getAverageCryptoPrices() {
//        return cryptoService.getAverageCryptoPrices();
//    }
//}
