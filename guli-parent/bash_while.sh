#!/usr/bin/env bash
c=0
echo "c: $c"
while [ $c -le 5 ]; do
    echo "C value is $c"
    # shellcheck disable=SC2092
    c=`expr $c + 1`
done