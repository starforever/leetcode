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

cat - "$prob/Solution$sub.java" <<< "import java.util.*;
" > Solution.java
javac -classpath util Solution.java
rm Solution.java Solution.class
