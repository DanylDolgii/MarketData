CREATE TABLE crypto_price (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    currency_pair VARCHAR(255) NOT NULL,
    average_price DOUBLE NOT NULL
);
