# Java Swing Application

A simple Java Swing application built with Maven.

## Project Structure

```
java/
├── pom.xml
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── example/
│                   └── app/
│                       └── MainFrame.java
└── README.md
```

## Requirements

- Java 11 or higher
- Maven 3.6 or higher

## Build and Run

### Build the project:
```bash
mvn clean package
```

### Run the application:
```bash
mvn exec:java -Dexec.mainClass="com.example.app.MainFrame"
```

Or run the JAR file:
```bash
java -jar target/swing-app-1.0-SNAPSHOT.jar
```

## Features

- Simple Swing GUI with a form
- TextField for user input
- Button to submit
- Label to display results
