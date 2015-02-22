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

It can also be run on the command line to output random numbers:

```bash

java -jar NameMachine.jar 1000 females

java -jar NameMachine.jar 5000

```


### Limitations

- Name generation is bound to integer max, so you can only generate integer max names in one pass.  If you need more,
 just make more passes.


#### How Does it Work?

The name files used to generate random names are provides by the 1990 U.S. Census data.  The originals are [available on the web]
(http://www.census.gov/topics/population/genealogy/data/1990_census/1990_census_namefiles.html).  Along with the
names in ranked order is the Frequency in percent, Cumulative frequency in percent, and the rank.

We randomly select a name from the list by generating a random floating point number, and picking the first name that has a higher or equal
cumulative frequency than our random number.

=======
Name machine is a Java utility for generating random names with realistic probabilities of occurrence.  That's a
fancy way of saying names that you would expect to occur more often will do so.  It's great for generating sample data.

It's lightweight, and has no dependencies.


```java

NameMachine nm = new NameMachine();

nm.namesAsString(10)

// generate 1000 names as objects (
nm.namesAsObject(1000)

// generate only female names
nm.namesAsObject(1000, Gender.FEMALE)


```

### Limitations

- name generation is bound to integer max, so you can only generate integer max names in one pass.  If you need more,
 just make more passes.



### Two Step Probability

- First, we draw randomly to figure out how much of the cumulative frequency we want to draw from.  

#### About The Name Files

The name files used to generate the are provides by the 1990 U.S. Census.  The originals are [available on the web]
(http://www.census.gov/topics/population/genealogy/data/1990_census/1990_census_namefiles.html).  Along with the
names in ranked order is the Frequency in percent, Cumulative frequency in percent, and the rank.

