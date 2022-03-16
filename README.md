# CronExpressionParserMvnProject

# Getting Started

Cron Expression Parser

**Building the application using maven**

You can build and package the application in the form of a jar file using maven -

`cd cronExpressionParser
mvn clean package`

The above command will produce a standalone jar file named cronExpressionParser-0.0.1-SNAPSHOT.jar in the 
cronExpressionParser/target directory.

**Running tests**

The `mvn package` command runs all the unit tests and also packages the application in the form of a jar file. If you just want to run the tests without packaging it, then you can use mvn test command.

`cd cronExpressionParser
mvn test`

**Running the application**
You can run the jar file created by the mvn package command like so -

`java -jar .\target\cronExpressionParser-0.0.1-SNAPSHOT.jar`
