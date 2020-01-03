#!/bin/bash
sh compile.sh # compile
# create link to bin
MY_PATH=$'#!/bin/bash\njava -classpath ${PWD// /\\ }'
echo "$MY_PATH/ MainActivity"  > vocablearner
chmod +x vocablearner
cp vocablearner /usr/local/bin
sudo chmod 755 /usr/local/bin/vocablearner
# move vocab lists to ~/Jvocab_learner/vocab_list/
mkdir -p $HOME/Jvocab_learner/vocab_list/
cp -R ./vocab_list $HOME/Jvocab_learner/
