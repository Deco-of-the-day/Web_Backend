# microservices 구조 생성

1. 개별 서비스 프로젝트 생성

```
spring init \
--boot-version=2.3.4.RELEASE \
--build=gradle \
--java-version=11 \
--packaging=jar \
--name=user-service \
--package-name=com.dotd.microservices.core.user \
--groupId=com.dotd.microservices.core.user \
--dependencies=actuator,webflux \
--version=1.0.0-SNAPSHOT \
user-service
```

```
spring init \
--boot-version=2.3.4.RELEASE \
--build=gradle \
--java-version=11 \
--packaging=jar \
--name=product-service \
--package-name=com.dotd.microservices.core.product\
--groupId=com.dotd.microservices.core.product\
--dependencies=actuator,webflux \
--version=1.0.0-SNAPSHOT \
product-service
```

2. 복합 서비스 프로젝트 생성

```
spring init \
--boot-version=2.3.4.RELEASE \
--build=gradle \
--java-version=11 \
--packaging=jar \
--name=user-composite-service \
--package-name=com.dotd.microservices.core.user \
--groupId=com.dotd.microservices.core.user \
--dependencies=actuator,webflux \
--version=1.0.0-SNAPSHOT \
user-composite-service
```