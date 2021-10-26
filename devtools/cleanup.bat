@ REM Cleans up Docker container and images.

docker container rm sls
docker image rm sls:1-SNAPSHOT
docker image prune --force