Name Machine
-----------------------
[![Build Status](https://travis-ci.org/ajbrown/NameMachine.svg?branch=develop)](https://travis-ci.org/ajbrown/NameMachine)
[![Coverage Status](https://coveralls.io/repos/ajbrown/NameMachine/badge.svg?branch=develop)](https://coveralls.io/r/ajbrown/NameMachine)
[![Join the chat at https://gitter.im/ajbrown/NameMachine](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/ajbrown/NameMachine?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)


Name machine is a Java utility for generating random names with realistic probabilities of occurrence.  In other words,
names that occur more often in real life will also occur more often in the random generation.

It's lightweight, and has no dependencies.  It loves being used to generate sample data for tests and demos!


```java
NameGenerator generator = new NameGenerator();

// generate 1000 female names
List<Name> names = generator.generateNames( 1000, Gender.FEMALE );


// generate 5000 male and female names.
List<Name> names = generator.generateNames( 5000 );
```

It can also be run on the command line to output random numbers:

```bash

java -jar NameMachine.jar 1000 females

java -jar NameMachine.jar 5000

```


#### Limitations

- The maximum number of random names you can generate in one pass is bound to integer max.  However, that's on order of 2 billion names on 32 bit systems.  At the time of writing there were only an estimated 7 billion humans on the planet, and most of those people don't have American names.  I just wasted your time describing a limitation that is actually not a limitation.

- There are only 4275 female first names and 1219 male first names represented.  However, with the 88 thousand last names, there are about **380 million** female and **108 million** male full name combinations available.


#### How Does it Work?

The name files used to generate random names are provides by the 1990 U.S. Census data.  The originals are [available on the web]
(http://www.census.gov/topics/population/genealogy/data/1990_census/1990_census_namefiles.html).  Along with the
names in ranked order is the Frequency in percent, Cumulative frequency in percent, and the rank.

We randomly select a name from the list by generating a random floating point number, and picking the first name that has a higher or equal
cumulative frequency than our random number.

#### Installing

Release versions of this library are sync'ed with [jCenter](https://bintray.com/bintray/jcenter).  Installation is as simple as adding it as a dependency

...to build.gradle:
```groovy
repositories {
    jCenter()
}

dependencies {
    compile 'org.ajbrown:NameMachine:0.1.1'
}
```


...to pom.xml:
```xml

<repositories>
  <repository>
    <id>jcenter</id>
    <url>http://jcenter.bintray.com</url>
  </repository>
</repositories>

<dependencies>
 <dependency>
   <groupId>org.ajbrown</groupId>
   <artifactId>NameMachine</artifactId>
   <version>0.1.1</version>
 </dependency>
</dependencies>
```

#### About the Author

You can always contact me directly with your questions, suggestions, or friendly conversation:

- **Email:** aj AT ajbrown DOT org
- **Twitter:** [@adrianjbrown](https://twitter.com/adrianjbrown)
- **Web:** [http://ajbrown.org](https://ajbrown.org)
