#!/usr/bin/env bash
read -p "请输入字符串" str
if [ "$str" = 'hello' ]; then
  echo 'world'
else
  echo "请输入hello"
fi