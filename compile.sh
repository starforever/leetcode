if [ "$1" ]
then
  probid="$1"
else
  echo "Problem ID required."
  exit
fi

if [ "$2" ]
then
  sub="_$2"
else
  sub=""
fi

cat - "$probid/Solution$sub.java" <<< "import java.util.*;
" > Solution.java
javac -classpath util Solution.java
rm Solution.java Solution.class
