#!/bin/sh
PID=`ps -ef | grep -e countly.jar | grep -v grep | awk '{print $2}'`
echo $PID
kill -9 $PID
echo 'Application is stopped.'
echo 'Start application.'
source /opt/start.sh

#nohup java -jar -Djava.security.egd=file:/dev/./urandom countly.jar --server.port=52321 > nohup.out &
#echo `date` - restarting ais>> restart.log

#PID=$(ps -ef | grep 项目.jar | grep -v grep | awk '{ print $2 }')
#
#       if [ -z "$PID" ]
#       then
#       echo Application is already stopped
#
#       else
#       echo $PID
#       kill $PID
#       fi