#Latest news on what is happening in OpenPojo.

# News #
  * **2015-02-08:**
    * OpenPojo-0.6.5 released download using Maven or from http://bit.ly/1oiDOun
      * Added
        1. PojoMethod.getPojoParameters now returns a list of PojoParameters, for each you can interrogate parameterization, get annotations, or get actual type.
        1. PojoClass.getPojoFieldsAnnotatedWith(Annotation), now retrieves all fields for a given Annotation.
        1. PojoClass.getPojoMethodsAnnotatedWith(Annotation), now retrieve all methods for a given annotation.
  * **2015-01-26:**
    * OpenPojo-0.6.4 released download using Maven or from http://bit.ly/1oiDOun
      * Fixed
        1. Standard out messages about coverage detection framework - [Issue 50](https://code.google.com/p/openpojo/issues/detail?id=50). (Thanks to Arngrimur B.)
      * Added
        1. PojoClass now has isStatic() method to enable quick check for static declaration of nested classes.
      * Changed
        1. LoggerFactory now doesn't rely on ActiveLogger utility class - which has been removed, and isn't coupled to PojoClass.
  * **2015-01-19:**
    * OpenPojo-0.6.3 released download using Maven or from http://bit.ly/1oiDOun
      * Fixed
        1. Issue when creating nested class that is declared non-static.
      * Added
        1. Generics enhancements, testers will now generate proper types for Map types.
        1. Constructors that required generic bags (Collection / Map / Custom) are now invoked with the proper types. ([Issue 49](https://code.google.com/p/openpojo/issues/detail?id=49))
      * Changed
        1. Whenever a general Map is requested, a HashMap will be used.
        1. All Map & Collection randomly generated will have between 1 and 5 items randomly added of the proper compatible generic type.
  * **2014-11-06:**
    * OpenPojo-0.6.2 released download using Maven or from http://bit.ly/1oiDOun
      * Fixed
        1. [Issue 43](https://code.google.com/p/openpojo/issues/detail?id=43) - Filesystem class discovery was running into issues with spaces (%20).  (Thanks to J.Karlsson & L.Osiatis)
        1. [Issue 46](https://code.google.com/p/openpojo/issues/detail?id=46) - Running PojoValidator on Synthetic classes throw Null Pointer in InstanceFactory.createInstance.  (Thanks to stumc68).
  * **2014-11-01:**
    * OpenPojo-0.6.1 released download using Maven or from http://bit.ly/1oiDOun
      * Added
        1. Generics are finally here, Setter/Getter testers will now generate proper types for Collections (Set, List, Queue).  This is an initial release, all feedback welcomed!
      * Changed
        1. If OpenPojo fails to get files from system path it won't throw null pointer anymore, but will throw proper exception with enough information to help trouble shoot.
      * Fixed
        1. [issue 47](https://code.google.com/p/openpojo/issues/detail?id=47) - Method lookup now works if the type is boolean and the field name starts with is (i.e. isFlagOn, ...etc).
  * **2014-10-08:**
    * OpenPojo-0.6.0 released download using Maven or from http://bit.ly/1oiDOun
      * Added
        1. Performance boost up to 2x while using BusinessIdentity - Cache remains for the lifetime of the VM.  (Thanks to Dilip J for his help testing & confirming performance gains)
        1. Auto-discovery for instrumentation frameworks, now pluggable, no more need to pass in FilterCloverClasses to PojoClassFactory.
        1. [Issue 43](https://code.google.com/p/openpojo/issues/detail?id=43) will now log as error and skip package paths that fail to enumerate - Please report logs on issue.
      * Removed
        1. ServiceRegistrar class filter & class adaptation services removed, all is now handled by the PojoCoverageFilterService.
  * **2014-09-03:**
    * OpenPojo-0.5.2 released download using Maven or from http://bit.ly/1oiDOun
      * Added
        1. Support for Clover 4.0
      * Fixed
        1. [Issue 44](https://code.google.com/p/openpojo/issues/detail?id=44) Identity factory is now thread safe, an issue that affects testing with multi-threaded on.
  * **2014-07-07:**
    * OpenPojo-0.5.1 released download using Maven or from http://bit.ly/1oiDOun
      * Fixed
        1. [Issue 38](https://code.google.com/p/openpojo/issues/detail?id=38) Minor issue when handling paths with spaces while decoding / encoding the %20.
  * **2014-03-02:**
    * OpenPojo-0.5.0 released download using Maven or from http://bit.ly/1oiDOun
      * Added
        1. Support for Clover 1.3.12.
        1. Support for Cobertura ([Issue 41](https://code.google.com/p/openpojo/issues/detail?id=41) - Thanks to Croesus K).
      * Fixed
        1. [Issue 42](https://code.google.com/p/openpojo/issues/detail?id=42) Error when PojoClass has arrays as fields and setter cloned it (Thanks to Jan O).
  * **2014-01-26:**
    * OpenPojo-0.4.9 released download using Maven or from http://bit.ly/1oiDOun
      * Added
        1. BusinessIdentity.toString(Object), now allows support passing in null objects (returns "null").
  * **2013-12-10:**
    * OpenPojo-0.4.8 released
      * Fixed
        1. InstanceFactory failing to skip synthetic constructor when it is the first one in the list.
  * **2013-12-08:**
    * OpenPojo-0.4.7 released
      * Added
        1. PojoClass, PojoMethod & PojoField now all support isSynthetic() check.
      * Fixed
        1. Error when PojoValidator attempts to construct PojoClass utilizing Synthetic (Thanks to Ting L).
  * **2013-10-27:**
    * OpenPojo-0.4.6 released
      * Fixed
        1. BusinessIdentity.areEqual() call is now non blocking thread safe (Thanks to David K).
        1. @BusinessKey annotated native arrays are now handled correctly for equality and hashCode (Thanks to Dillon E).
  * **2013-07-05:**
    * OpenPojo-0.4.5 released
      * Added
        1. Affirm.affirmContains call to simplify checking that an object is in a collection.
        1. Support for Enum.class random value generation.
  * **2013-06-23:**
    * OpenPojo-0.4.4 released
      * Fixed
        1. [Issue 31](https://code.google.com/p/openpojo/issues/detail?id=31) if the getter returns a super class will not cause a getter to be ignored anymore - a reversal on [issue 27](https://code.google.com/p/openpojo/issues/detail?id=27) fix (Thanks to  JeanLasVEGAs for reporting the issue).
        1. [Issue 36](https://code.google.com/p/openpojo/issues/detail?id=36) now OpenPojo works with JDK 1.5, there was an issue with loading JDK 1.6 specific classes causing cascading error in JDK 1.5 (Thanks to briancallaghan2 for reporting the issue).
  * **2013-02-24:**
    * OpenPojo-0.4.3 released
      * Fixed
        1. [Issue 35](https://code.google.com/p/openpojo/issues/detail?id=35), Issue while enumerating classes in a jar file while handling package names (Thanks to LHCper for uncovering this issue).
  * **2012-09-30:**
    * OpenPojo-0.4.2 released
      * Fixed
        1. Possible null pointer exception when attempting to register null PojoClassAdapter, or attempting to adapt a null PojoClass.
  * **2012-09-29:**
    * OpenPojo-0.4.1 released
      * Fixed
        1. [Issue 29](https://code.google.com/p/openpojo/issues/detail?id=29), OpenPojo will now skip JaCoCo imbedded fields allowing you to capture coverage reports from EclEmma (Thanks to nox1119 for uncovering this issue).
  * **2012-08-14:**
    * OpenPojo-0.4.0 released
      * Fixed
        1. [Issue 26](https://code.google.com/p/openpojo/issues/detail?id=26) with @Entity conflict between using default constructor for Getter/Setter testers and @BusinessKey needing required fields. (Thanks to Andrew W. for uncovering this issue).
        1. [Issue 27](https://code.google.com/p/openpojo/issues/detail?id=27) when getter returns different type than declared on field or setter. (Thanks to Douglas L for uncovering this issue)
      * Added
        1. NoFieldShadowingRule to detect re-declaration of fields with the same name in subclasses [Issue 28](https://code.google.com/p/openpojo/issues/detail?id=28). (Thanks to Benoit for the suggestion)
        1. Added a method in PojoMethod to retrieve the return type of the underlying method.
  * **2012-04-07:**
    * OpenPojo-0.3.10 released
      * Fixed
        1. A minor issue with MessageFormatter when sent an Array wrapped in Object.
        1. Needing to type cast random values generated by RandomFactory
      * Added
        1. Support for generating java native arrays (i.e. byte[.md](.md), Integer[.md](.md), Person[.md](.md), ...etc).
        1. Added isArray() member to PojoClass.
      * Removed
        1. Deprecated PackageHelper class.
  * **2011-12-04:**
    * OpenPojo-0.3.9 released
      * Fixed an issue with running OpenPojo over windows mounted files systems (Thanks to Kajetan F. and Michael G. for uncovering this issue)
      * Added support for intelligent RandomFactory generation (i.e. if you register a LinkedList generator, it will be also used if a Collection, List, AbstractList...etc are requested).
  * **2011-11-22:**
    * OpenPojo-0.3.8 released
      * Fixed [issue 22](https://code.google.com/p/openpojo/issues/detail?id=22) (Thanks to Sharan for catching this).
      * Added performance boost to BusinessKey fields lookup yielding over 2x preliminary testing for equality & hashCode generation.
  * **2011-10-10:**
    * OpenPojo-0.3.7 released
      * Fixed [issue 21](https://code.google.com/p/openpojo/issues/detail?id=21).
      * Added support for Filtering PojoClasses by name using regex ([issue 20](https://code.google.com/p/openpojo/issues/detail?id=20)).
  * **2011-8-26:**
    * OpenPojo-0.3.6 released
      * Fixed [issue 19](https://code.google.com/p/openpojo/issues/detail?id=19) (Thanks to David K. for catching this).
      * Added support for Collections and Map random generation namely the following types will now be randomly generated (Thanks to Kajetan F for pointing out the need for this):
        1. Collection
        1. List, ArrayList, LinkedList
        1. Set,  HashSet, TreeSet, LinkedHashSet
        1. Queue, BlockingQueue, LinkedBlockingQueue, PriorityBlockingQueue, DelayQueue, SynchronousQueue.
        1. Map, TreeMap, HashMap, LinkedHashMap, IdentityHashMap, WeakHashMap, ConcurrentHashMap
  * **2011-5-03:**
    * OpenPojo-0.3.5 released
      * Fixed [issue 18](https://code.google.com/p/openpojo/issues/detail?id=18) (Thanks to Stephan M. for catching this).
  * **2011-2-22:**
    * OpenPojo-0.3.4 released
      * Added
        * New rule to allow public fields as long as they are 'static final' ([issue 15](https://code.google.com/p/openpojo/issues/detail?id=15)).
  * **2010-12-03:**
    * OpenPojo-0.3.3 released - Licensing is now LGPL instead of GPL.
  * **2010-11-13:**
    * OpenPojo-0.3.2 released
      * Added
        * OpenPojo will now enumerate classes & packages in JAR files as well as file system.
      * Deprecated
        * PackageHelper class is no longer used and will be removed in 0.4.x releases.
  * **2010-11-05:**
    * OpenPojo-0.3.1 released
      * Added
        * FilterCloverClasses to filter out clover classes while enumerating..
        * FilterNestedClasses to filter out subclasses while enumerating.
        * PojoField now has two new methods (isParameterized, and getParameterTypes) for generics support.
      * Fixed
        * Issue with PojoClass showing up more than once when a package spans multiple directories.
        * Issue with InstanceFactory failing to construct if type was not equal to required, now works if type is assignable to required.
        * Issue with BusinessIdentityTester failing to detect hashCode not being dispatched to BusinessIdentity.
      * Removed
        * LoggingException unused.
        * ValidationException unused.
        * Log4JLogger and SLF4JLogger don't detect or configure the underlying logging framework anymore.
        * Deprecated constructors in filters that took in prior filter, use FilterChain to achieve the same effect now.
  * **2010-10-22:**
    * OpenPojo-0.2.0 released
      * JUnit is now optional, if you don't have TestNG or JUnit, OpenPojo will throw Java's AssertionError.
      * Fixed minor issue with PojoClassFactory when package and system path aren't 1 - 1 (one to one).
        * PackageHelper.getPackageAsDirectory() removed.
        * PackageHelper.getPackageAsDirectories() introduced to replace previous.
  * **2010-10-21:**
    * OpenPojo-0.1.4 released
      * Fixed minor issue with InstanceFactory failing to construct when constructor utilized primitive type (i.e. int, boolean, short, ...etc).
      * Logger logs have been reworked and cleaned up, formats for Exceptions logging slightly modified to keep all exception log on one line with full stack trace.
  * **2010-10-20:**
    * OpenPojo-0.1.3 released
      * New Class<?> RandomGenerator (side issue uncovered while working on [issue 14](https://code.google.com/p/openpojo/issues/detail?id=14)).
      * New EnumSet<?> RandomGenerator. (The fix for [issue 14](https://code.google.com/p/openpojo/issues/detail?id=14) - Thanks to David K. for uncovering this issue).
    * First performance test done on OpenPojo, 1,000 POJOs tested with all rules including business rules under 3 secs (details soon).
    * UML graphs are back in the javadocs.jar (if you can't see them, just unjar and navigate with browser - and once more Thanks to David K. for helping with the pom.xml).
  * **2010-10-18:**
    * OpenPojo-0.1.2 released
      * New PojoClassFilter added (FilterEnum) (solving [issue 12](https://code.google.com/p/openpojo/issues/detail?id=12) & [issue 13](https://code.google.com/p/openpojo/issues/detail?id=13)).
      * New FilterChain now enables chaining any filters together.
      * **Note:** please **skip version 0.1.1** on maven central and go straight to 0.1.2.
  * **2010-10-15:**
    * OpenPojo-0.1.0 released
      * [Issue 12](https://code.google.com/p/openpojo/issues/detail?id=12) is fixed.
      * All deprecated code has now been removed namely
        * DefaultValuesNullRule class removed (use DefaultValuesNullTester instead).
        * GetterSetterMustExistRule class removed (use individual GetterMustExistRule & SetterMustExistRule instead)
        * PojoField.inovkeSetter method removed (use PojoField.invokeSetter instead).
  * **2010-10-14:**
    * OpenPojo is now available throw maven (see http://bit.ly/dma1wJ).
    * Moving forward artifacts published here will be just a zip of what gets pushed into Maven central.
    * Fixed typo on PojoField.invokeSetter was misspelled (inovkeSetter), old method deprecated for now - Thanks to Hawk N for catching this.
  * **2010-09-27:**
    * PojoClass, PojoMethod & PojoField now extend PojoElement, all three now implement getAnnotation(s) api.
  * **2010-09-25:**
    * Added support for isTransient() & isVolatile() on PojoField (thanks Thomas R.).
  * **2010-09-23:**
    * Added support for getAnnotations on PojoField (thanks [Micro2nd](http://code.google.com/u/mikro2nd/))
  * **2010-08-31:**
    * Added support for registering field prefixes.
  * **2010-08-28:**
    * Fixed a minor issue (#8) with paths that include spaces on windows (file enumeration was failing).
    * JavaDocs now includes UML diagram on all classes/interfaces generated via UMLGraphDoc (http://www.umlgraph.org/).
  * **2010-08-03:**
    * Added InstanceFactory a new class that can create any PojoClass utilizing one of three ways
      * Exact argument list (FactoryInstance.getInstance(PojoClass, Object... parameters)
      * Random utilizing the minimal available constructor (i.e. the one with the least number of parameters)
      * Random utilizing the most complete available constructor (i.e. the one with the most number of parameters).
    * RandomFactory now falls back on InstanceFactory for a given type if it can't find a registered RandomGenerator for.
  * **2010-06-22:**
    * Fixed a problem with the wiring of the assertion framework not detecting that TestNG not available and throwing initialization errors.
  * **2010-06-21:**
    * Added a BusinessIdentityTester to validate that equals and hashcode calls for a POJO are actually being dispatched to BusinessIdentity facade.
    * Added BusinessKeyMustExistRule to validate that at least one @BusinessKey has been defined and is set to required.
    * Also IdentityFactory now can be configured to route calls to custom IdentityHandler using register/unregister allowing interception of equality/hashcode/validate calls for greater flexibility (specially when writing custom Testers).
  * **2010-06-01:**
    * @BusinessKey annotation is now inherited by child classes for equality & hash code generation.
  * **2010-05-26:**
    * Added support for dynamically creating random instance for any Interface reference.
    * Added support for dynamically creating random enum for any custom enum.
    * Added a facade for Asserts with auto-select based on user env (auto detect and select routing for Asserts, TestNG then JUnit).
    * Added a facade for logging with auto-select based on user env (auto detect and select routing for logs, SLF4J, Log4J then Java Logger)
  * **2010-05-20:**
    * All code is now being tested using unit tests. 100% code coverage.
  * **2010-05-12:**
    * Added PojoClass.getMethods call that returns a list of all PojoMethods adding more control on methods introspection and invocation.
  * **2010-04-22:**
    * Added java.math.BigDecimal to BasicRandomGenerator (Thanks to Arun S.).
    * Added java.math.BigInteger to BasicRandomGenerator.
  * **2010-04-16:**
    * Test coverage is > 80%.
    * Added java.util.Date to BasicRandomGenerator (Thanks to Arun S.).
    * PojoClassImpl.newInstance(Object[.md](.md)) now works matching argument count.
  * **2010-04-12:** Added source jar to the downloadable zip file.
  * **2010-03-29:** Added Javadoc to the package zip file.
  * **2010-03-22:** Added **toString** implementation that allows you to just delegate using BusinessIdentity.toString(this) calls, will String-inize all contents of your Class.
  * **2010-03-11:** Now fully tested and certified the code is pretty stable main features include
    1. **HashCode** & **Equals** can now be done using the **BusinessKey** annotation, just include the openpojo.jar in your runtime environment.
    1. Testing done using Rules, and Testers easily.