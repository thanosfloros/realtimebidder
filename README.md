# Spring RealTimeBidderApp Application

## Running RealTimeBidderApp locally
RealTimeBidderApp is a [Spring Boot](https://spring.io/guides/gs/spring-boot)
Application uses Java 17 and spring boot 2.6.2.
Application is built using [Maven](https://spring.io/guides/gs/maven/). You 
can build a jar file and run it from the command line:


```
cd RealTimeBidderApp
$ mvn spring-boot:run
java -jar target/*.jar
```

## Working with UserApp in your IDE

### Prerequisites
The following items should be installed in your system:
* Java 11 or newer.
* Your prefered IDE
    * Eclipse with the m2e plugin. Note: when m2e is available, there is an m2 icon in `Help -> About` dialog. If m2e is
      not there, just follow the install process here: https://www.eclipse.org/m2e/
    * [Spring Tools Suite](https://spring.io/tools) (STS)
    * IntelliJ IDEA

### Steps:

1) Run the app
Inside Eclipse or STS
```
File -> Import -> Maven -> Existing Maven project
```

Then either build on the command line `./mvnw generate-resources` or using the Eclipse launcher (right click on project and `Run As -> Maven install`) to generate the css. Run the application main method by right clicking on it and choosing `Run As -> Java Application`.

Inside IntelliJ IDEA

In the main menu, choose `File -> New -> Project from existing sources` and select the RealTimeBidderApp [pom.xml](pom.xml). Click on the `Open` button.

`Run 'RealTimeBidderApp'`.

When the server is running open your browser and call the APIs using swagger

[Real_Time_Bidder_APIs](http://localhost:8080/swagger-ui/#/)

2) Run the tests 

via IDE

Under src/test/java, open RealTimeBidderTest, right click -> run
Under src/test/java, open CampaignServiceTest, right click -> run

Run all tests with maven
`mvn test'`.

