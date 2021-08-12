#!/usr/bin/env bash
#输入一个数字，如果是1，则输出banzhang zhen shuai，如果是2，则输出cls zhen mei，如果是其它，什么也不输出。
if [ $1 -eq "1" ];then
  echo "banzhang zhen shuai"
elif [ $1 -eq "2" ]; then
   echo "cls zhen mei"
fi
