Before running this test, you should go the current directory of this sample to issue the following maven command :
This will download the required Selenium dependencies.

1. Import this project into Eclipse
2. Switch to the GW4E perspective
3. Open the *Distributor/src/test/resources/com/company/DrinkDispenser.json* file ont he graph model editor
4. Have a look at how the graph is made
5. Right-click the *Distributor/src/test/java/com/company/DrinkDispenserImpl.java* file and select "Run As" -> 'GW4E Test'
6. Have a look at the Console, there are many interesting logs. Notice that this launched with the GraphWalker annotation pathgenerator value
7. Right-click the *Distributor/src/test/java/com/company/DrinkDispenserImpl.java* file and select "Run As" -> 'JUnit Test'
8. Have a look at the Console, there are many interesting logs. Notice that all JUnit methods have been executed.

You can run the test with maven. You can switch to a command shell and issue the following maven command 
```
mvn clean install
```


