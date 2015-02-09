if [ "$1" ]
then
  probid="$1"
else
  echo "Problem ID required."
  exit
fi

if [ "$2" ]
then
  sub1="_$2"
  sub2=" ($2)"
else
  sub1=""
  sub2=""
fi

mkdir -p "$probid"
touch "$probid/Solution$sub1.java"
echo "Initialized problem with ID $probid$sub2."
