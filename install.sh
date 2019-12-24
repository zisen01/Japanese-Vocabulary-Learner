#!/bin/sh
sh compile.sh
MY_PATH="#!/bin/sh\njava -classpath ${PWD// /\ }"
echo "$MY_PATH/ MainActivity"  > vocablearner
chmod +x vocablearner
cp vocablearner /usr/local/bin
sudo chmod 755 /usr/local/bin/vocablearner
