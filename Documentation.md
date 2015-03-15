

# Overview of the System #
OpenPojo has a few important to note components listed bellow.  However, before diving in, here is the big picture on what the system looks like...

> ![http://openpojo.googlecode.com/svn-history/r233/wiki/img/package_overview.png](http://openpojo.googlecode.com/svn-history/r233/wiki/img/package_overview.png)

## Runtime ##
Classes considered runtime are designed to help with **identity management** and **logging**.

**Identity management** in JAVA takes on three aspects which are:
  1. Equality (Object.equals method)
  1. Hash Code generation (Object.hashCode method)
  1. String-anization (Object.toString method)

**Logging** was introduced just because there is a need to make logging flexible and allow OpenPojo to log to whatever logging framework is available during - primarily - runtime, and/or testing time.<br>
The framework is clean and is now core to OpenPojo, feel free to utilize it in all your code simplifying your logging and freeing you to plug any third party library underlying without having to worry about how your code will deal with their intricacies.<br>
<br>
<h3>Business package</h3>
The business package is responsible for all identity management aspects.<br>
This package is the reason why you want to include openpojo.jar in your run time environment to simplify hashcode, equals and toString calls.<br>
All this can be done through the BusinessIdentity entry point to the package.<br>
To use the BusinessIdentity class you need to:<br>
<ol><li>Annotate your fields with @BusinessKey<br>
</li><li>Wire your equals, hashcode and toString straight to its static calls.</li></ol>

<blockquote><img src='http://openpojo.googlecode.com/svn-history/r231/wiki/img/business_pkg_overview.png' /></blockquote>

<ul><li>BusinessIdentity<br>
<blockquote>This class exposes three basic methods that you can use in your Pojos to generate hashcode, equals and toString.<br>
<ol><li>hashCode & areEqual are used as a pair and both get their cue off of the @BusinessKey annotation.<br>
</li><li>toString, is unique as it just prints out all variables and their content for a PojoClass.</li></ol></blockquote></li></ul>

<ul><li>BusinessKey<br>
<blockquote>Use this annotation to highlight what fields in your Pojo are to be used for hashcode generation and equality.  Possible configuration parameters on this annotation are<br>
<ol><li>caseSensitive (used to indicate to ignore case when comparing CharacterSequence classes).<br>
</li><li>required (used to indicate don't allow field to be null upon equality or hashcode generation).<br>
</li><li>composite (used to indicate this field is part of a group that can have null fields, as long as one member of the group isn't null).</li></ol></blockquote></li></ul>

<h3>Log package</h3>
The log package is responsible for logging, it was developed so openpojo can log any of its errors/exceptions correctly through whichever framework you have enabled in production, it will detect SLF4J, Log4j and if neither is available it will fall back to Java's built in logging framework.<br>
<br>
If you wish to wire your own logging to openpojo for flexibility then you'll need to use the Logger and LoggerFactory classes<br>
<br>
<blockquote><img src='http://openpojo.googlecode.com/svn-history/r230/wiki/img/log_pkg_overview.png' /></blockquote>

<ul><li>LoggerFactory<br>
<blockquote>This factory will return an instance of Logger to be used for logging.<br>
</blockquote></li><li>Logger<br>
<blockquote>This abstract class wraps the underlying layer and simplifies where actual logs go.  The Logger exposes all the needed methods to log in various levels starting from <i>trace</i> all the way to <i>fatal</i> with the corresponding checks to see if a level is open.  The main difference between this logging framework and others is that you have the ability to pass in a message as a string with tokens, and an argument list that gets converted to string and rendered in the message.<br>
For example if you call<br>
<blockquote><code> info("Logging from {0}", this); </code>  <- Same but faster than -> <code> info("Logging from " + this); </code>
</blockquote>An added benefit to logging with tokens is the ability to externalize your messages enabling internationalization.<br>
The Logger also handles <i>Arrays</i> turning them to strings as well as exceptions etc...</blockquote></li></ul>

<h2>Testing</h2>
Classes in the Testing domain are used to help you enforce <i>static</i> as well as <i>behavioral</i> rules on your POJOs.<br><br>
For example if you want to say <i>"I want anyone implementing this interface to be immutable"</i> - meaning no setters, and all fields are final... this is only a simple example and I am sure you can think of even better things you want to enforce in your own code.<br><br>
I have included some of the common rules / tests that I needed and think most people will want to use those in some combination or another, and am open to extending the rule set based on feedback.<br>
<br>
<h3>Validation package</h3>
The validation package is responsible for all things related to validation, there is one class and two interfaces that you need to familiarize yourself with.<br>
<br>
<blockquote><img src='http://openpojo.googlecode.com/svn-history/r247/wiki/img/validation_pkg_overview.png' /></blockquote>

<ul><li>PojoValidator<br>
<blockquote>This class is the one responsible for executing validations against a PojoClass.  To use it you create your own instance, and configure it (add rules and testers), then run the validation against a PojoClass of choice.<br>
</blockquote></li><li>Rule<br>
<blockquote>This interface is the parent for all rules.  Rules validate a PojoClass's structure, not behaviour (i.e. no PojoClass instance created for rule's evaluation).  As of writing this documentation there are 9 pre-built rules, feel free to add your own or let me know and I'll add them.</blockquote></li></ul>

<blockquote><img src='http://openpojo.googlecode.com/svn-history/r249/wiki/img/Rule_impl.png' /></blockquote>

<ul><li>Tester<br>
<blockquote>This interface is the parent for all testers.  Testers validate a PojoClass's behaviour not structure (i.e. a new instance of PojoClass will be created to run test.  Currently, there are 4 pre-build Tester(s), feel free to add your own or let me know and I'll add them.</blockquote></li></ul>

<blockquote><img src='http://openpojo.googlecode.com/svn-history/r249/wiki/img/Tester_impl.png' /></blockquote>

<h3>Random package</h3>
The random package is responsible for generating random values.<br>
<blockquote><img src='http://openpojo.googlecode.com/svn-history/r254/wiki/img/random_pkg_overview.png' />
</blockquote><ul><li>RandomFactory<br>
<blockquote>The random factory is responsible for constructing random values of various types.  Out of the box, the following types are supported:<br>
</blockquote><ol><li>All Primitives and their Object counter parts (i.e. int and Integer, long and Long, ...etc) - 16 types.<br>
</li><li>String<br>
</li><li>java.util.Date & java.util.Calendar.<br>
</li><li>BigDecimal & BigInteger.<br>
</li><li>java.sql.Timestamp.<br>
</li><li>any Enum values.<br>
</li><li>Object.<br>
</li></ol><blockquote>In addition, the RandomFactory will do a best attempt to generate for dynamically<br>
</blockquote><ol><li>Interface - a dynamic proxy will be created for the interface that will return random data for any of its method invocations.<br>
</li><li>Concrete class (i.e. any custom class defined), the RandomFactory will construct dynamically an instance of requested class and return the instantiated instance.</li></ol></li></ul>

<ul><li>RandomGenerator<br>
<blockquote>If you want to write your own random generator, go ahead and implement this interface.</blockquote></li></ul>

<h3>Reflection package</h3>
The reflection package is the heart of OpenPojo, it has many interfaces and many more classes.  The top level of the package has the interface building and has the following:<br>
<blockquote><img src='http://openpojo.googlecode.com/svn-history/r253/wiki/img/reflection_pkg_overview.png' /></blockquote>

<ul><li>PojoClass<br>
<blockquote>The PojoClass single most important class in the system and one that you need to understand well.  This class is a meta representation for Java Classes.  It is a simplified version of Class to provide all the mechanics you need to test the class.  The PojoClass holds PojoFields (meta representation for Field), and PojoMethods (meta representation for Method and Constructor).  To create a PojoClass see the PojoClass Factory bellow.<br>
</blockquote></li><li>PojoField<br>
<blockquote>The PojoField is a wrapper for Java's Field.  In addition it holds pointers to the Getter and Setter methods and has the ability to return the data from a field on an Instance using direct access or through invocation of the getter, same for setting.<br>
</blockquote></li><li>PojoMethod<br>
<blockquote>The PojoMethod wrapps Method and Constructor Java concepts.  Gives you the ability to invoke the Method/Constructor with given parameters.</blockquote></li></ul>

<ul><li>PojoClassFilter<br>
<blockquote>The PojoClassFilter is a way to filter in/out certain PojoClasses from being included when enumerating your classes at large.  For example, say you want to enumerate all abstract classes in your code base.  Create a PojoClass filter that returns PojoClass.isAbstract().  Then when you call the PojoClassFactory pass an instance of that filter to it.<br>
</blockquote></li><li>PojoPackage<br>
<blockquote>The PojoPackage encapsulates and represents a Package in Java, it has convenient methods for enumerating Package contents.</blockquote></li></ul>

Most implementations will create an PojoClass using the following factory:<br>
<blockquote><img src='http://openpojo.googlecode.com/svn-history/r253/wiki/img/reflection_impl_factory.png' />
</blockquote><ul><li>PojoClassFactory<br>
<blockquote>This factory is the way to create PojoClasses to pass around or write your <i>Tester</i> / <i>Rule</i> against.  It has the ability to create single or enumerate at bulk.<br>
</blockquote><ul><li><b>Note:</b> package-info.java will be enumerated as it is represented internally (interface), if you want to remove it, use <code> com.openpojo.reflection.filters.FilterPackageInfo </code></li></ul></li></ul>

<h2>Other Important Classes/Interfaces</h2>
<ul><li>RandomFactory<br>
<blockquote>This factory is very handy and heavily used when creating random instances of a given class.  Register your own RandomGenerator into it and it will be called every time a random object of that type is needed.<br>
</blockquote></li><li>RandomGenerator<br>
<blockquote>This interface defines the contract needed to be implemented so you can register your own custom types into the RandomFacotory.  Feel free to over-ride the default implementations provided for random generation of all the basic java types including Timestamp.</blockquote></li></ul>

<ul><li>InstanceFactory<br>
<blockquote>This factory is to be used to construct any PojoClass and give a new instance for it.  It has the ability to create using one of three methods.<br>
<ul><li>Exact : which can be used when you are wiring to an actual PojoClass and you want an instance of it and you know what constructor parameters you want to use.<br>
</li><li>Random Minimal : which creates an instance using the constructor with the <i>least</i> parameters.<br>
</li><li>Random Complete : which creates an instance using the constructor with the <i>most</i> parameters.