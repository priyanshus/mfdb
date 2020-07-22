DROP TABLE IF EXISTS SCHEME_DETAILS;
CREATE TABLE SCHEME_DETAILS (
                                scheme_code INT(6) NOT NULL,
                                scheme_name VARCHAR(512),
                                PRIMARY KEY (scheme_code)
);

DROP TABLE IF EXISTS NAV_HISTORY;
CREATE TABLE NAV_HISTORY (
                      date DATE NOT NULL,
                      scheme_code INT(6) NOT NULL ,
                      isin_div_payout VARCHAR(255),
                      isin_div_reinvestment VARCHAR(255),
                      nav FLOAT(20) NOT NULL ,
                      repurchase_price FLOAT (20),
                      sale_price FLOAT (20),
                      PRIMARY KEY(date)
);

DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS (
    mobile_number VARCHAR(15) NOT NULL,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    primary key (mobile_number)
);

