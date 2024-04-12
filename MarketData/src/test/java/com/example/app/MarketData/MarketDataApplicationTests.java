package com.example.app.MarketData;

import com.example.app.MarketData.model.CryptoPrice;
import com.example.app.MarketData.repository.CryptoPriceRepository;
import com.example.app.MarketData.service.CoinbaseAPIService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class MarketDataApplicationTests {

	@Autowired
	private CryptoPriceRepository cryptoPriceRepository;

	@MockBean
	private CoinbaseAPIService coinbaseAPIService;

	@Test
	public void testSaveCryptoPrice() {
		// Create sample crypto price
		CryptoPrice cryptoPrice = new CryptoPrice();
		cryptoPrice.setCurrencyPair("BTC-USD");
		cryptoPrice.setAveragePrice(50000.0);

		// Save crypto price
		cryptoPriceRepository.save(cryptoPrice);

		// Retrieve saved crypto price from database
		List<CryptoPrice> savedCryptoPrices = cryptoPriceRepository.findAll();

		// Verify that crypto price was saved
		assertNotNull(savedCryptoPrices);
		assertEquals(1, savedCryptoPrices.size());

		// Verify that saved crypto price matches the expected values
		CryptoPrice savedCryptoPrice = savedCryptoPrices.get(0);
		assertEquals("BTC-USD", savedCryptoPrice.getCurrencyPair());
		assertEquals(50000.0, savedCryptoPrice.getAveragePrice());
	}

}
