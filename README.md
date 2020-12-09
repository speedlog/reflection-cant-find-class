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

You can find solution on branch [solution](https://github.com/speedlog/reflection-cant-find-class/tree/solution).