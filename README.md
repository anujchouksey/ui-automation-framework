# ui-automation-framework
Selenium+Maven+TestNG

A. Pre-requisities:-

1.Configure maven for the windows - https://maven.apache.org/install.html
To execute the script run the following command 

B. Execute the code
For Chrome:-
mvn -Dmaven.surefire.debug -Dbrowser=CHROME -Dsuites=regression.xml test
For Firefox:-
mvn -Dmaven.surefire.debug -Dbrowser=FIREFOX -Dsuites=regression.xml test


Happy Coding!!
