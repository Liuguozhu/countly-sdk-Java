ps -ef | grep countly.jar | grep -v grep | cut -c 9-15 | xargs kill -s 9
