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

javac -classpath util "$prob/Solution$sub.java"
