@ REM Runs locally a new container.

docker run -p 8080:8080 --name sls -it sls:1-SNAPSHOT

docker container rm sls