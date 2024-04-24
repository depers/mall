#!/bin/bash
LOG_PATH="/usr/local/myapp/program/nginx/logs"
RECODE_TIME=$(date -d "yesterday" +%Y-%m-%d+%H:%M)
PID=/usr/local/myapp/program/nginx/logs/nginx.pid

mv ${LOG_PATH}/access.log ${LOG_PATH}/access.${RECODE_TIME}.log
mv ${LOG_PATH}/error.log ${LOG_PATH}/error.${RECODE_TIME}.log

# 向nginx主进程大发送信号，用于重新打开日志文件
kill -USR1 `cat $PID`