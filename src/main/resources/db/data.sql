INSERT INTO NAV_HISTORY (
    date,
    scheme_code,
    isin_div_payout,
    isin_div_reinvestment,
    nav,
    repurchase_price,
    sale_price
)
VALUES ('2020-07-01', 141926, 'INF846K01B02', 'INF846K01B10', 10.05, null, null);

INSERT INTO SCHEME_DETAILS (scheme_code, scheme_name)
VALUES ( 141926, 'Axis Multicap Fund - Direct Plan - Dividend' );

INSERT INTO USERS (first_name, last_name, mobile_number)
VALUES ( 'root', 'user', '1234567890' );