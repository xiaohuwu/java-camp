#!/usr/bin/env bash
cd /tmp/test
for (( i = 0; i < 3; i++ )); do
    mkdir "dir$i"
done
cp /etc/hosts /tmp/test/dir1
echo "完成 $(date +%F)"