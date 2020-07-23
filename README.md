# mfdb
A dummy Rest application to learn test automation.

To run the app, download the jar file available at https://github.com/priyanshus/mfdb/releases/download/v1.0.0/mfdb-1.0.0.jar. 

Use `java -jar mfdb-1.0.0.jar` to start the server. The server will be running on 8080 port.


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
    "otpToken": "<jwt-received-from-/signup-endpont> or <999999>"
}
```

Response:

```
{"token":"<some-jwt>"}
```

-----------------------------------
To get scheme details

GET http://localhost:8080/api/v1/schemes/141926

Authorization: `jwt-received-from-authentication-response`

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

Authorization: `jwt-received-from-authentication-response`
    
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
