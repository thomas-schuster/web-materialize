# Web Materialize

This is a sample project that demonstrates the integration of materialize css into a common JSF application. The project serves as minimal template to demonstrate the following things:

1. A simple user interface based on JSF. [Primefaces](https://www.primefaces.org/showcase/) and [MaterializeCSS](https://materializecss.com/) are used to implement material design.
2. Some simple CDI beans that are used via Unified Expression Language (UEL) in conjunction with the user interface.
3. A simple stateless session bean (UserController). This bean is also exposed as REST service.
4. Exemplary integration tests based on [Failsafe](http://maven.apache.org/surefire/maven-failsafe-plugin/), [Cargo](https://codehaus-cargo.github.io/cargo/Home.html) and JUnit. This includes:
   - Web-based interface tests performed with [Web Driver](https://www.seleniumhq.org/projects/webdriver/). For an easy setup, a [GitHub project](https://github.com/bonigarcia/webdrivermanager) by Boni Garcia is included. 
   - Simple web service tests with the help of [RestEasy](https://resteasy.github.io/).
   
## Current Status
The application includes a landing page with some sample content and a typical navbar, some links in it and a login page (called from the button in the navbar). The login is a dummy login just used to illustrate some layout functionality. 

The example serves as a minimum example. To limit the scope to the essentials, the example does not include the user control or security mechanisms you would expect from a production-ready application.

### Build & Deployment
The project is configured to be built and deployed by means of common maven goals. More convenience may be reached by using an IDE such as NetBeans, IntelliJ oder eclipse. 

1. In order to enable a quick build and installation, tests may be skipped during **clean**, **install** and **package** commands. 
2. The project is ready to be executed on [Payara 182](https://www.payara.fish/)

## Execution of Integration Tests
Two profiles are prepared in order to execute the integration tests. One profile does execute all tests against a remote payara server, the other profile executes all tests against wildfly. The second profile will utilize maven to download and fire up wildfly as test environment.

To execute integration tests against payara and skip unit tests, execute the following maven command
```console
foo@bar:~$ mvn verify -Dskip.surefire.tests -P payaratest 
```
Keep in mind that you need to have payara up and running. In addition payara connection is defined by the project's pom-file as:
```XML
<payara.adminPort>50192</payara.adminPort>
<payara.username></payara.username>
<payara.password></payara.password>
<payara.hostname>localhost</payara.hostname>
<payara.domainName>domain1244</payara.domainName>
<payara.home></payara.home>
<payara.domainDir>${payara.home}/glassfish/domains</payara.domainDir>
```
feel free to change this configuration or alter your payara configuration to match to it. If you intend to test on wildfly, you may call instead
```console
mvn verify -Dskip.surefire.tests -P wildflytest 
```

