#!/usr/bin/env bash
#从1加到100
#sum=0
#for (( i = 1; i <= 100; i++ )); do
#    sum=`expr $sum + $i`
#done
#echo "sum: $sum"


res=$((3+2))
echo "res:$res"
res2=$[ 3 + 2 ]
echo "res2:$res2"
res3=`expr 3 + 2`
echo "res3:$res3"

