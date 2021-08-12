#!/usr/bin/env bash
city=`cat city.txt`
for item in $city;do #需要给美元才能掉变量
  echo $item
done
