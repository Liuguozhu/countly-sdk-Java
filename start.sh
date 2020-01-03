#!/bin/sh
echo "nohup java -server -Xms64m -Xmx128m -jar -Djava.security.egd=file:/dev/./urandom countly.jar --spring.profiles.active=prod &"
. /etc/profile
nohup java -server -Xms64m -Xmx128m -jar -Djava.security.egd=file:/dev/./urandom countly.jar --spring.profiles.active=prod > log.file 2>&1 &
