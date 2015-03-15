# How do I generate a random instance of my class? #
There are two ways to generate a random instance of a class.

## Method 1: I need any instance, then use RandomFactory ##

```
MyClass myClass = RandomFactory.getRandomValue(MyClass.class);
```

### What if my class is an Interface? ###
If you pass in an interface, you will get a proxy instance, this instance will implement the interface.
It will also return the correct return types for every method invocation.

The returned values will always be random.

#### Example ####
Suppose you have an interface that looks like this
```
public interface MyInterface {
  String getName();
}
```
and you do
```
MyInterface myInterface = RandomFactory.getRandomValue(MyInterface.class);
System.out.println("Name: " + myInterface.getName());
System.out.println("Name: " + myInterface.getName());
```
The output will be:
```
Name: 3pQLM
Name: Wt24e
```

## Method 2: I want to use a particular constructor, then use InstanceFactory ##
```
PojoClass myClassAsPojoClass = PojoClassFactory.getPojoClass(MyClass.class);
MyClass myClass = (MyClass) InstanceFactory.getInstance(myClassAsPojoClass, arg1, arg2);
```

Actually I just want to use the most complete constructor on the Pojo, I just don't know which one.
```
PojoClass myClassAsPojoClass = PojoClassFactory.getPojoClass(MyClass.class);
MyClass myClass = (MyClass) InstanceFactory.getMostCompleteInstance(myClassAsPojoClass);
```