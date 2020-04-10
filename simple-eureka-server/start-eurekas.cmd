call mvn clean package -D skipTests

echo 'Build docker image...'

call docker build -t simple-eureka-server .

call docker-compose up -d