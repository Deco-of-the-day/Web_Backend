# docker를 사용한 마이크로서비스 배포

### 단일 마이크로서비스(user-service) 도커로 실행

1. JAR 파일 빌드
```
cd /dotd_work # 프로젝트 위치
./gradlew :microservices:user-service:build
```
2. Dockerfile를 이용해 도커 이미지 빌드
```
cd microservices/user-service
docker build -t user-service .
```
3. 도커 이미지 확인
```
docker images | grep user-service
```
4. 서비스 시작
```
docker run --rm -p8000:8000 -e "SPRING_PROFILES_ACTIVE=docker" user-service
```
- 컨테이너의 8080 포트를 도커 호스트의 8080 포트에 매핑해 외부에서 호출할 수 있게 한다.
- 컨테이너를 시작할 때 사용하는 도커 이미지 이름 : user-service
- 랜덤한 이름의 컨테이너가 생성된다.
5. 실행 중인 도커 컨네이터 확인 및 중지&제거
```
docker ps
```
```
docker rm -f brave_galileo
```
--------

참고 문헌 <br><br>
1. Hands-On Microservices with Spring Boot And Spring Cloud(번역판)
<br> 스프링으로 하는 마이크로서비스 구축