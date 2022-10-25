gradlew clean build
docker image build ./ -t relex-image

# run relex-service container
# docker run -p 8081:8081 -d --name relex-service relex-image
# stop relex-service container
# docker stop relex-service
