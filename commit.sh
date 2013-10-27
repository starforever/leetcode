git add "$1"/Solution.java
if [ "$2" ]
then
  status="$2"
else
  status="Accepted"
fi
if [ "$3" ]
then
  git commit -m "($1) [$status] $3"
else
  git commit -m "($1) [$status]"
fi
