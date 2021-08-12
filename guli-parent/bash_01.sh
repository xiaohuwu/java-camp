#!/usr/bin/env bash
if [ 1  -gt $1 ];then
  echo "1 大于 b"
else
  echo "1 小于 b"
fi

if (( 1 < $1 ));then
  echo "1 大于 b"
else
  echo "1 小于 b"
fi

n=10
for (( i=0; i<$n; i++ )); do
    echo "value: $i"
done