if [ "$1" ]
then
  if [ -d "$1" ]
  then
    echo "Directory $1 already exists."
  else
    mkdir "$1"
    touch "$1"/Solution.java
    echo "Initialized $1."
  fi
else
  echo "Problem name required."
fi
