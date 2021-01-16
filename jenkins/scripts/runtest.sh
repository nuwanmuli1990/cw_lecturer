set -x
java -jar target/lecturer-0.0.1-SNAPSHOT.jar &
sleep 1
echo $! > .pidfile
set +x
