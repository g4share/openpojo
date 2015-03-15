# Why OpenPojo? #
A lot of developers feel that there is no need to test getters/setters or other aspects of simple objects, I STRONGLY disagree and here is why.

Most developers have seen the problem of `name = name` assignment in the setter, and know that since it should be `this.name = name` one way to solve it is through making parameters final.

So do you enforce through checkstyle all parameters to be final? And if you do, how do you catch the sneaky developer that decided to do `this.name = lower(name)`, because it was easy to manipulate the POJO than modify the service with a business rule?

POJOs were created as light weight storage structures that give the JAVA developer the ability to create types, in general, they should never have "business" logic in them, and the get should return EXACTLY what the set received, in fact if you call "set(object), then do object.equals(get()), and not get TRUE", you have violated the POJO contract.

I have been in many projects, have seen all sorts of bugs that were introduced through laziness, or otherwise, code decay, and many other reasons.    I have also seen projects collapse under the weight of the testing structures.  One change causes all sorts of tests to break, and I am convinced 100% of the agile way of thinking of "test boundary conditions", "test code at the behavior concerns".

Typical project code structure is going to be made of hundreds of structures, tens of behaviors, and a hand full of services, your tests must reflect that, most of your testing should be done at the foundational pieces, but since the foundation is always made of aspects (i.e. Persistables, Cache, etc), you can utilize OpenPojo to help you define what rules/behaviours these aspects must follow, and run all your code through it automatically.

Nothing wastes more time than to write "getter/setter" tests when you're testing hard.

Nothing is more rewarding than dropping a new class in your package and it gets automatically regressed for you to ensure it complies...

And so OpenPojo was born...