#Object Modeling

###composite pattern
https://www.draw.io/#G1osf3cI3GP8EAaQ4J859ikYVmrhtn-Iyo

###rest
host.tld/some/path/:var

Status codes
1. 200 OK
1. 201 Created
1. 204 No Content
1. 304 Not Modified
1. 400 Bad Request
1. 401 Not Authorized
1. 404 Not Found
1. 500 Internal Server Error


User Service
-----------
DATA
```json
{
  "userId": 17,
  "userName": "hanna",
  "userStatus": "gold" 
}
```

req: A user without userId
resp: A user with userId

