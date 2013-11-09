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
  sub2=" ($2)"
else
  sub=""
  sub2=""
fi

mkdir -p "$prob"
touch "$prob/Solution$sub.java"
echo "Initialized $prob$sub2."
