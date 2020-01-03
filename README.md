# Japanese-Vocabulary-Learner
Although the name says Japanese, this script is not limited to just Japanese vocabularies.

# Installation
## MacOS
  1. to install various packages, you need HomeBrew (this is my personal recommendation, you can use other package manager that you like, but the examples are in homebrew)
  get it here: https://brew.sh
  2. you need Java development kit to compile the java code, so you need have JDK installed.
  ```
  brew cask install java
  ```
  3. you need git, or you can download the package, too, but I recommend git for ease of upgrade.
  ```
  brew install git
  ```
  4. use
  ```
  git clone https://github.com/zisen01/Japanese-Vocabulary-Learner.git
  ```
  to clone the repository, and cd into the repository.
  5. run the shell script using bash
  ```
  sudo bash install.sh
  ```
  then the application is installed and you can simply type 'vocablearner' in the terminal to run the app.
  
## Linux
  1. you need Java development kit to compile the java code, so you need have JDK installed.
  e.g.In Ubuntu, run the following code
  ```
  sudo apt-get update --fix-missing
  sudo apt-get install default-jdk
  ```
  2. you need to have bash as most of my shell script is written in bash.
  I think most Linux distributuion comes with bash, (unless you're a minimalist and use gentoo,etc. But then you don't need me to you tell you what to do, don't you :) )
  If there is no bash in your distribution, you will most likely be able to install it using your distribution's package manager.
  e.g. In Ubuntu, run the following code
  ```
  sudo apt-get update 
  sudo apt-get install bash
  ```
  3. you need git, or you can download the package, too, but I recommend git for ease of upgrade.
  e.g. In Ubuntu, run the following code
  ```
  sudo apt-get update
  sudo apt-get install git
  ```
  4. use
  ```
  git clone https://github.com/zisen01/Japanese-Vocabulary-Learner.git
  ```
  to clone the repository, and cd into the repository.
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
  
  2. go to the Microsoft store and select the WSL you like (I presonally recommend Ubuntu for the abundance of the community helf it provides), install it and follow the installation guide for Linux
