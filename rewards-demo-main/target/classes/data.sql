-- name=src/main/resources/schema.sql
CREATE TABLE IF NOT EXISTS billed_transactions (
                                                   id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                                   transaction_time TIMESTAMP,
                                                   amount DECIMAL(19,2),
    billed BOOLEAN,
    matched BOOLEAN,
    description VARCHAR(255)
    );

INSERT INTO billed_transactions (transaction_time, amount, billed, matched, description) VALUES
                                                                                             ('2026-03-01T09:15:00Z', 100.00, true, true, 'Invoice #1001'),
                                                                                             ('2026-03-01T10:00:00Z', 250.00, false, false, 'Manual entry'),
                                                                                             ('2026-03-02T11:20:00Z', 75.50, true, false, 'Invoice #1002'),
                                                                                             ('2026-03-03T13:00:00Z', 300.00, true, true, 'Invoice #1003'),
                                                                                             ('2026-03-03T14:30:00Z', 10.00, false, true, 'Adjustment');

CREATE SCHEMA IF NOT EXISTS card_financial_transactions;

CREATE TABLE IF NOT EXISTS card_financial_transactions.wdet_process_log (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    payload VARCHAR(255) NOT NULL,
    process_status VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS card_financial_transactions.billed_transactions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    statement_closing_date DATE NOT NULL,
    amount DECIMAL(19,2),
    description VARCHAR(255)
);

INSERT INTO card_financial_transactions.wdet_process_log (payload, process_status) VALUES
    ('{"stmt_date":"260315"}', 'PROCESSED'),
    ('{"stmt_date":"260315"}', 'PROCESSED'),
    ('{"stmt_date":"260315"}', 'PROCESSED'),
    ('{"stmt_date":"260315"}', 'FAILED'),
    ('{"stmt_date":"260316"}', 'PROCESSED');

INSERT INTO card_financial_transactions.billed_transactions (statement_closing_date, amount, description) VALUES
    (DATE '2026-03-15', 100.00, 'Statement billing row 1'),
    (DATE '2026-03-15', 200.00, 'Statement billing row 2'),
    (DATE '2026-03-15', 300.00, 'Statement billing row 3'),
    (DATE '2026-03-16', 150.00, 'Other statement billing row');
