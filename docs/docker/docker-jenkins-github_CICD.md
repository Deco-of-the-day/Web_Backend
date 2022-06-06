# Github -> Jenkins -> Docker Hub CI/CD

<br>

### Overview
1. 개발자가 github, mater branch에서 코드를 push 한다.
2. jenkins container 에서 해당 소스 코드를 pull 한다.
3. jenkins 내에서 docker image를 build 한다.
4. docker hub에 해당 image를 push 한다.
5. 추가적으로 필요하다면, docker run 을 하여 서버에 적용한다
   ( 우리는 서버를 로컬에서 돌리는 단계이기 때문에 docker run은 하지 않았음 )

<br>

--------


### Jenkins 컨테이너 생성

```
docker run --name jenkins --rm -d -p 8080:8080 -p 50000:50000 -v $(which docker):/usr/bin/docker -v $PWD/jenkins:/var/jenkins_home -v /var/run/docker.sock:/var/run/docker.sock -u root jenkins/jenkins:lts-jdk11
```
- jenkins/jenkins:lts-jdk11 이미지가 존재하지 않는다면, pull 를 먼저 실행한다.
- 8080 포트는 tomcat 기본 포트이기 때문에 겹치는 것 주의
- -p <호스트 포트> : <컨테이너 포트>, 호스트 포트를 변경 예정
- /var/jenkins_home 에 저장되는 jenkins 의 데이터는 영구적이지 않기 때문에 영구적인 볼륨을 만들어 둔다.
- docker vol 공유와 관련된 명령어는 필요하지 않다 ( 내부에 docker 설치 예정)

#### Jenkins 컨테이너에 Docker 설치
```
curl -fsSLO https://get.docker.com/builds/Linux/x86_64/docker-17.04.0-ce.tgz \
  && tar xzvf docker-17.04.0-ce.tgz \
  && mv docker/docker /usr/local/bin \
  && rm -r docker docker-17.04.0-ce.tgz
```

#### 생성한 Jenkins에 root 계정으로 접속
```
docker exec -it -u root jenkins /bin/bash
```

#### docker login 확인 (optional)

<br>

--------

### Jenkins 컨테이너 외부로 공유 ( github webhook 연동시 필요 )


#### ngrok 설치
   https://ngrok.com/download

#### ngrok 실행 (port number 변경 예정)
```
./ngrok http 8080
```
<br>

--------

### Github Webhook + Jenkins

#### github repository 내 Webhook setting
1. Payload URL 에선 반드시 jenkins 외부 공유 url 뒤에 '/github-webhook/' 추가
2. Content type : application/json
3. Secret : ssh key

#### Jenkins settings
1. global credential 에 추가
2. 설정한 key 값은 pipeline에서 사용

<br>

--------

### Jenkins Pipeline Project 생성

#### 구성 설정
- option1 : Do not allow the pipeline to resume if the controller restarts
- option2 : GitHub hook trigger for GITSom polling (web hook)

#### Pipeline Script
```
pipeline {
    agent any
    
    environment {
        GIT_URL = "https://github.com/Deco-of-the-day/Web_Backend.git"
    }


    stages {
        stage('Checkout') {
            steps {
                git url: "${GIT_URL}", credentialsId: '<token name>', branch: "<branch name>", poll: true, changelog: true
            }
        }
        
        stage('Build') {
            steps {
                sh './gradlew :microservices:user-service:build --stacktrace'
                dir('./microservices/user-service'){
                    sh 'pwd'
                    sh 'docker build -t <docker hub user name>/<repository name>:<tag name> .'
                }
            }
        }
        
        stage('Deploy') {
            steps{
                // sh 'docker run --rm --name dotd-container <full name> -p8000:8000 -e "SPRING_PROFILES_ACTIVE=docker" user-service'
                sh 'docker push <docker hub user name>/<repository name>:<tag name>'
                
            }
        }

       stage('Finish') {
            steps{
                sh 'docker images -qf dangling=true | xargs -I{} docker rmi {}'
            }
        }
    }
}
```

+ pipeline : docker pipeline, github integration
+ ngrok 재 실행 되면, github에서 webhook 값 변경
--------

참고 사이트 <br><br>
1. Webhook - Jenkins <br> https://junhyunny.github.io/information/jenkins/github/jenkins-github-webhook/
2. How to use docker in Jenkins Docker Image
   <br> https://postlude.github.io/2020/12/26/docker-in-docker/
   <br> https://stackoverflow.com/questions/44850565/docker-not-found-when-building-docker-image-using-docker-jenkins-container-pipel
3. Jenkins 설정 <br> https://velog.io/@dion/Jenkins-with-Docker-and-GitHub


