--create account table
CREATE TABLE accounts (
    account_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    document_number VARCHAR(255) NOT NULL
);

-- Create operationTypes table
CREATE TABLE operationTypes (
    operation_type_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(255) NOT NULL
);

-- Create transactions table
CREATE TABLE transactions (
    transaction_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    account_id BIGINT NOT NULL,
    operation_type_id BIGINT NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    balance DECIMAL(10, 2) NOT NULL,
    event_date TIMESTAMP NOT NULL,
    FOREIGN KEY (account_id) REFERENCES accounts(account_id),
    FOREIGN KEY (operation_type_id) REFERENCES operationTypes(operation_type_id)
);


-- Insert data into OperationTypes
INSERT INTO operationTypes (operation_type_id, description)
VALUES
(1, 'Normal Purchase'),
(2, 'Purchase with Installments'),
(3, 'Withdrawal'),
(4, 'Credit Voucher');