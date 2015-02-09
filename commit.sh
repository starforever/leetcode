if [ "$1" ]
then
  probid="$1"
else
  echo "Problem ID required."
  exit
fi

if [ "$2" ]
then
  title="$2"
else
  echo "Problem title required."
  exit
fi

if [ "$3" ]
then
  sub="_$3"
else
  sub=""
fi

if [ "$4" ]
then
  status="$4"
else
  status="Accepted"
fi

if [ "$5" ]
then
  info=" $5"
else
  info=""
fi

git add "$probid/Solution$sub.java"
git commit -m "($title) [$status]$info"
