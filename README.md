# lab-shop-eventsourcing4


```
cd order
mvn spring-boot:run
```

- another terminal
```
http :8081/orders id=1 productId=1
http :8081/orders id=2 productId=1

http :8081/orderStatuses     #shows the order status is null
```

- another terminal
```
cd delivery
mvn spring-boot:run
```

- test again
```
http :8081/orderStatuses     #shows the order status 'DeliveryStarted' when the delivery service is started
```



- mysql
```
 docker exec -it infra-mysql-1 /bin/bash
 mysql --user=root --password=$MYSQL_ROOT_PASSWORD
 create database delivery
```