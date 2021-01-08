DROP TYPE IF EXISTS type_address;
CREATE TYPE type_address AS ENUM ('HOME', 'BUSINESS');

DROP TYPE IF EXISTS type_account;
CREATE TYPE type_account AS ENUM (
    'SAVINGS',
    'CHECKING',
    'MONEY_MARKET',
    'CERTIFICATES_OF_DEPOSIT',
    'RETIREMENT',
    'BROKERAGE',
    'STUDENT'
);

CREATE TABLE address
(
    a_id           BIGSERIAL,
    a_first_line   VARCHAR(100) NOT NULL,
    a_second_line  VARCHAR(100),
    a_zip_code     VARCHAR(20)  NOT NULL,
    a_city         VARCHAR(50)  NOT NULL,
    a_country_code CHAR(2)      NOT NULL,
    a_type         type_address NOT NULL,

    CONSTRAINT pk_address__a_id PRIMARY KEY (a_id)
);

CREATE TABLE customer
(
    c_id             UUID DEFAULT uuid_generate_v4(),
    c_account_number BIGSERIAL    NOT NULL,
    c_first_name     VARCHAR(100) NOT NULL,
    c_middle_name    VARCHAR(100),
    c_last_name      VARCHAR(100),
    c_dob            DATE         NOT NULL,
    c_email          VARCHAR(100),
    c_phone_number   VARCHAR(25)  NOT NULL,
    c_address_id     BIGINT       NOT NULL,
    c_account_type   type_account NOT NULL,

    CONSTRAINT pk_customer__c_id PRIMARY KEY (c_id),
    CONSTRAINT fk_customer__c_address_id___address__a_id
        FOREIGN KEY (c_address_id) REFERENCES address (a_id)
);