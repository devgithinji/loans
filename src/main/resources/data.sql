
DROP TABLE IF EXISTS loans;

CREATE TABLE loans
(
    loan_number        INT AUTO_INCREMENT NOT NULL,
    customer_id        INT                NOT NULL,
    start_dt           TIMESTAMP          NOT NULL,
    loan_type          VARCHAR(100)       NOT NULL,
    total_loan         INT                NOT NULL,
    amount_paid        INT                NOT NULL,
    outstanding_amount INT                NOT NULL,
    create_dt          VARCHAR(255),
    CONSTRAINT pk_loans PRIMARY KEY (loan_number)
);

INSERT INTO loans (customer_id, start_dt, loan_type, total_loan, amount_paid, outstanding_amount, create_dt)
VALUES (  1, CURDATE()-250, 'Home', 200000, 50000, 150000, CURDATE()-250);

INSERT INTO loans (customer_id, start_dt, loan_type, total_loan, amount_paid, outstanding_amount, create_dt)
VALUES ( 1, CURDATE()-376, 'Vehicle', 40000, 10000, 30000, CURDATE()-376);

INSERT INTO loans (customer_id, start_dt, loan_type, total_loan, amount_paid, outstanding_amount, create_dt)
VALUES (  1, CURDATE()-549, 'Home', 50000, 10000, 40000, CURDATE()-549);

INSERT INTO loans (customer_id, start_dt, loan_type, total_loan, amount_paid, outstanding_amount, create_dt)
VALUES (   1, CURDATE()-122, 'Personal', 10000, 3500, 6500, CURDATE()-122);

