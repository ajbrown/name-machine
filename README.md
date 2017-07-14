[![Build Status](https://travis-ci.org/ajbrown/NameMachine.svg?branch=master)](https://travis-ci.org/ajbrown/NameMachine)
[![Coverage Status](https://coveralls.io/repos/ajbrown/NameMachine/badge.svg?branch=master)](https://coveralls.io/r/ajbrown/NameMachine)
[![Maven Central](https://img.shields.io/maven-central/v/org.ajbrown/name-machine.svg)]()
[![Join the chat at https://gitter.im/ajbrown/NameMachine](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/ajbrown/NameMachine?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![Say thanks with a donation](https://button.flattr.com/flattr-badge-large.png)](https://flattr.com/submit/auto?fid=3pepqd&url=https%3A%2F%2Fgithub.com%2Fajbrown%2FNameMachine)

Name Machine
-----------------------


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

It can also be run on the command line to output random names:

```bash

java -jar name-machine.jar 1000 females

java -jar name-machine.jar 5000

```

#### Gender probability

When generating names for both genders, there is a slightly higher chance of generating a female name than a male name.  
This is in line with the real-world male-to-female ratio in the United States.  This ratio can be adjusted for your specific
 application using the `NameGeneratorOptions`:

```java
NameGeneratorOptions options = new NameGeneratorOptions();

//Heavily prefer male names.
options.setGenderWeight( 12.23 );
NameGenerator generator = new NameGenerator( options );
generator.generateNames( 1000 );
```


#### Limitations

- The maximum number of random names you can generate in one pass is bound to integer max.  However, that's on order of 2 billion names on 32 bit systems.  At the time of writing there were only an estimated 7 billion humans on the planet, and most of those people don't have American names.  I just wasted your time describing a limitation that is actually not a limitation.
- There are only 4275 female first names and 1219 male first names represented.  However, with over 150 thousand last names, there are about **645 million** female and **184 million** male full name combinations available.


#### How Does it Work?

The name files used to generate random names are provides by the 1990 U.S. Census data.  The originals are [available on the web]
(http://www.census.gov/topics/population/genealogy/data/1990_census/1990_census_namefiles.html).  Along with the
names in ranked order is the Frequency in percent, Cumulative frequency in percent, and the rank.

We randomly select a name from the list by generating a random floating point number, and picking the first name that has a higher or equal
cumulative frequency than our random number.

#### Installing

...to build.gradle:
```groovy

dependencies {
    compile 'org.ajbrown:name-machine:1.0.0'
}
```


...to pom.xml:
```xml
<dependencies>
 <dependency>
   <groupId>org.ajbrown</groupId>
   <artifactId>name-machine</artifactId>
   <version>1.0.0</version>
 </dependency>
</dependencies>
```

#### About the Author

You can always contact me directly with your questions, suggestions, or friendly conversation.

- **Email:** aj AT ajbrown DOT org
- **Twitter:** [@adrianjbrown](https://twitter.com/adrianjbrown)
- **Web:** [http://ajbrown.org](https://ajbrown.org)
