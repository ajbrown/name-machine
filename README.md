Name Machine
-----------------------

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

