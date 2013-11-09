prob="$1"
if [ "$2" ]
then
  status="$2"
else
  status="Accepted"
fi
if [ "$3" ]
then
  info=" $3"
else
  info=""
fi
if [ "$4" ]
then
  sub="_$4"
else
  sub=""
fi

git add "$prob/Solution$sub.java"
git commit -m "($prob) [$status]$info"
