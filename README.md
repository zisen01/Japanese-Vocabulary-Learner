# Japanese-Vocabulary-Learner

Although the name says Japanese vocabulary, this script is not limited to just Japanese vocabularies.

the script comes with Genki I & II vocabulary in default. You can add your own vocabulary, too, vocabulary in other languages are also supported.

# Installation
## MacOS
  1. to install various packages that we need, you need to install HomeBrew (this is my personal recommendation, you can use other package manager that you like, but the examples are in homebrew)
  
  get it here: https://brew.sh
  
  2. you also need Java development kit to compile the java code.
  ```
  brew cask install java
  ```
  the above command installs the latest JDK in default.
  3. you need git to clone the project (or you can download the package, but I recommend git for ease of upgrade.)
  ```
  brew install git
  ```
  
  4. use the following code to clone the repository, and cd into the directory.
  ```
  git clone https://github.com/zisen01/Japanese-Vocabulary-Learner.git
  cd Japanese-Vocabulary-Learner
  ```
  
  5. run the shell script using bash
  ```
  bash install.sh
  ```
  
  then the application is installed and you can simply type 'vocablearner' in the terminal to run the app.
  
## Linux
  1. you need Java development kit to compile the java code.
  
  e.g.In Ubuntu, run the following code
  ```
  sudo apt-get update --fix-missing
  sudo apt-get install default-jdk
  ```
  the above command installs the latest JDK in default.
  
  2. you need to have bash as most of my shell script is written in bash.
  
  I think most Linux distributuion comes with bash. (unless you're a minimalist and use gentoo, etc. But then you don't need me to you tell you what to do, don't you :) )
  
  If there is no bash in your distribution, you can install it using your distribution's package manager.
  
  e.g. In Ubuntu, run the following code
  ```
  sudo apt-get update 
  sudo apt-get install bash
  ```
  
  3. you need git to clone the project (or you can download the package, but I recommend git for ease of upgrade.)
  
  e.g. In Ubuntu, run the following code
  ```
  sudo apt-get update
  sudo apt-get install git
  ```
  
  4. use the following code to clone the repository, and cd into the directory.
  ```
  git clone https://github.com/zisen01/Japanese-Vocabulary-Learner.git
  cd Japanese-Vocabulary-Learner
  ```
  
  5. run the shell script using bash
  ```
  sudo bash install.sh
  ```
  
  then the application is installed and you can simply type 'vocablearner' in the terminal to run the app.
  
## Windows
  There is no native solution to windows currently, but you can install to WSL(Windows subsystem for Linux).
  
  to get WSL:
  1. you need to enable WSL in settings, you can paste the code below in your powershell to enable.
  ```
  Enable-WindowsOptionalFeature -Online -FeatureName Microsoft-Windows-Subsystem-Linux
  ```
  
  or you can search 'Turn Windows features on or off' at cortana search bar, click the first outcome. When the window pops up, scroll down and check the checkbox before the item 'Windows Subsystem for Linux'.
  
  2. go to the Microsoft store and select the WSL you like (I presonally recommend Ubuntu for the abundance of the community help it provides), install it and follow the installation guide for Linux

# Create Vocabulary list
  under your home directory, use the cd command:
  ```
  cd Jvocan_learner/vocab_list/
  ```
  
  and create a file using the editor you like, inside your file put the vocabulary you want to learn following the structure:
  [vocab]-[definition]
  
  e.g.えいご-English (language)
  
  spaces are allowed, there can only be one vocabulary each row.
  
# Uninstall
  under project directory, run command:
  ```
  bash uninstall.sh
  ```
  then remove the project folder
  
