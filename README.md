# mfdb
A dummy Rest application to learn test automation.

To run the app, download the jar file available under release section. Use `java -jar mfdb-<version>.jar` to start the server.


## APIs
To signup the user:

POST http://localhost:8080/api/v1/signup

Body:
```
{
    "mobileNumber": "1234567891",
    "firstName": "Some Value",
    "lastName": "Some Value"
}
```

Response:
```
{
    "otp": "<jwt>"
}
```
-----------------------------------

To authenticate the user.

POST http://localhost:8080/api/v1/authenticate/

Body:
```
{
    "username": "someuser",
    "password": "somepassword",
    "otpToken": "<jwt-received-from-/signup-endpong> or <999999>"
}
```

Response:

```
{"token":"<some-jwt>"}
```

-----------------------------------
To get scheme details

GET http://localhost:8080/api/v1/schemes/141926

Authorization: <jwt-received-from-authentication-response>

Response:
```
{
    "schemeCode": 141926,
    "schemeName": "Axis Multicap Fund - Direct Plan - Dividend"
}
```


-----------------------------------
To add a new scheme

POST http://localhost:8080/api/v1/schemes/add

Authorization: <jwt>
    
Body:
```    
{
    "schemeCode": 141927,
    "schemeName": "Axis Multicap Fund - Direct Plan - Dividend"
}
```

Response

```
{
    "message": "scheme added"
}
```
