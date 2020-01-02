#!/bin/bash
sh compile.sh # compile
# create link to bin
MY_PATH=$'#!/bin/sh\njava -classpath ${PWD// /\ }'
echo "$MY_PATH/ MainActivity"  > vocablearner
chmod +x vocablearner
cp vocablearner /usr/local/bin
sudo chmod 755 /usr/local/bin/vocablearner
# move vocab lists to ~/Jvocab_learner/
cp -R ./vocab_list $HOME/Jvocab_learner/
