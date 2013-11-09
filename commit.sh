if [ "$1" ]
then
  prob="$1"
else
  echo "Problem name required."
  exit
fi
if [ "$2" ]
then
  sub="_$2"
else
  sub=""
fi
if [ "$3" ]
then
  status="$3"
else
  status="Accepted"
fi
if [ "$4" ]
then
  info=" $4"
else
  info=""
fi

git add "$prob/Solution$sub.java"
git commit -m "($prob) [$status]$info"
