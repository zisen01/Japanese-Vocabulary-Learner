#!/bin/sh
sh compile.sh
MY_PATH=$PWD
echo "#!/bin/sh\njava -classpath $MY_PATH MainActivity"  > vocablearner
chmod +x vocablearner
cp vocablearner /usr/local/bin
sudo chmod 755 /usr/local/bin/vocablearner
