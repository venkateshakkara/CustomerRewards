CREATE TABLE IF NOT EXISTS sales (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     product VARCHAR(255),
    quantity INT,
    amount DOUBLE,
    created_at TIMESTAMP
    );

INSERT INTO sales (product, quantity, amount, created_at) VALUES
                                                              ('Widget A', 5, 100.00, TIMESTAMP '2026-01-10 10:00:00'),
                                                              ('Widget B', 3, 60.00, TIMESTAMP '2026-01-12 12:30:00'),
                                                              ('Widget A', 2, 40.00, TIMESTAMP '2026-02-05 09:15:00'),
                                                              ('Widget C', 7, 210.00, TIMESTAMP '2026-03-01 14:00:00');