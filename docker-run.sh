#!/bin/bash
docker build --tag=bnc-simulator:latest .
echo "Building docker image is completed"

# kill and remove old docker instance if running
if [ "$(docker ps -a | grep bnc-sim)" ]; then
   echo "Running instance found, begin to remove it..."
   docker rm -f bnc-sim
   sleep 10
fi

echo "Starting docker instance..."
docker run --privileged -dt --rm --name bnc-sim -p 5006:5006 -p 8080:8080 bnc-simulator:latest
sleep 5

