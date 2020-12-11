# Reflection can't find classes

I faced issue with Reflections, that I want to share with you.  
Finally solution was very simple, but about it later.

## Case

Write unit test that will check some conventions based on class name.  
Test needs to find all classes that extends another class.  
One solution is to find classes by Reflection library.  
See how it can be done in [unit test](src/test/java/pl/speedlog/example/reflection/SearchUsecaseTest.java).  

## Run tests

Project requires java 11.  
Run it `./mvnw test`.  

Unfortunately it doesn't pass.  
Reflection finds only 2 classes, but it should find 4.  

```
Expected :[class pl.speedlog.example.reflection.domain2.UsecaseC, class pl.speedlog.example.reflection.domain1.UsecaseB, class pl.speedlog.example.reflection.domain2.UsecaseD, class pl.speedlog.example.reflection.domain1.UsecaseA]
Actual   :[class pl.speedlog.example.reflection.domain2.UsecaseC, class pl.speedlog.example.reflection.domain1.UsecaseA]
```

## Solution

Solution was very simple. Project had transitive dependency to Reflection library with version 0.9.9-RC1.  
Just upgrade reflection library version.  

This version of reflection library can't read java classes that use some new features like lambda.
In example classes `UsecaseB` and  `UsecaseD` use lambda to filter list:
```java
...
.filter(text -> !text.equals("dd"))
...
```

I spent few hours to debug and find why it doesn't work, so i hope it can help save your time.    

### Lesson learned
* Change logging level to DEBUG or TRACE and try to find information related to your problem.  
* Use the most recent version of library that you use

Before updating library version in logs there is information:
```
23:18:48.305 [main] DEBUG org.reflections.Reflections - could not scan file pl/speedlog/example/reflection/domain1/UsecaseB.class in url file:/home/speedlog/repos/blog/reflection-cant-find-class/target/classes/ with scanner TypeAnnotationsScanner
23:18:48.306 [main] DEBUG org.reflections.Reflections - could not scan file pl/speedlog/example/reflection/domain1/UsecaseB.class in url file:/home/speedlog/repos/blog/reflection-cant-find-class/target/classes/ with scanner SubTypesScanner
23:18:48.307 [main] DEBUG org.reflections.Reflections - could not scan file pl/speedlog/example/reflection/domain2/UsecaseD.class in url file:/home/speedlog/repos/blog/reflection-cant-find-class/target/classes/ with scanner TypeAnnotationsScanner
23:18:48.308 [main] DEBUG org.reflections.Reflections - could not scan file pl/speedlog/example/reflection/domain2/UsecaseD.class in url file:/home/speedlog/repos/blog/reflection-cant-find-class/target/classes/ with scanner SubTypesScanner

```