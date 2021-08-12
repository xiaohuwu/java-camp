#!/usr/bin/env bash
#通过脚本判断远程计算机的存活状态 一共判断3次
host="www.baidu.com"
for (( ind=0 ; ind < 2 ; ind++ )); do
   ping -c1 $host &>/dev/null
   if [ $? -eq 0 ];then
     export "host_$ind"=0
   else
    export  "host_$ind"=1
   fi
done

if [ "$host_0" -eq "$host_1" ]&& [ "$host_0" -eq 0 ];then
  echo "$host  在线"
else
  echo "$host  宕机"
fi