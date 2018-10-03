/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ajbrown.namemachine;

/**
 * Configuration options for {@link NameGenerator}.
 *
 * @author A.J. Brown <a href="mailto:aj@ajbrown.org">aj@ajbrown.org</a>
 */
public class NameGeneratorOptions
{

  public static final double DEFAULT_GENDER_WEIGHT = 50.8;

  private double genderWeight = DEFAULT_GENDER_WEIGHT;

  private Long randomSeed;

  /**
   * <p>Determines the probability of a female name being generated over a male name.  Only applies when generating
   * names for both genders.</p>
   *
   * <p>Defaults to 50.8, which is the gender ratio reported by the
   * <a href="http://www.census.gov/prod/cen2010/briefs/c2010br-03.pdf">2010 U.S. Consensus</a>.</p>
   *
   * @return the weight that will be used to determine male vs female names
   */
  public double getGenderWeight() {
    return genderWeight;
  }

  /**
   * Set the gender weight.
   *
   * @param genderWeight A number between 0-100 determining the probability of a female name being generated.
   * @throws IllegalArgumentException when #genderWeight is negative.
   * @see #getGenderWeight()
   */
  public void setGenderWeight(final double genderWeight) throws IllegalArgumentException {
    if (genderWeight <= 0) {
      throw new IllegalArgumentException("genderWeight must be a positive number");
    }
    this.genderWeight = genderWeight;
  }

  /**
   * The seed used to initialize the pseudorandom number generator.
   *
   * @return the random seed
   */
  public Long getRandomSeed() {
    return randomSeed;
  }

  /**
   * Set the seed used to initialize the pseudorandom number generator.
   *
   * @param randomSeed A random seed.
   * @see #getRandomSeed()
   */
  public void setRandomSeed(Long randomSeed) {
    this.randomSeed = randomSeed;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    NameGeneratorOptions that = (NameGeneratorOptions) o;

    if (Double.compare(that.genderWeight, genderWeight) != 0) return false;
    return randomSeed != null ? randomSeed.equals(that.randomSeed) : that.randomSeed == null;
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    temp = Double.doubleToLongBits(genderWeight);
    result = (int) (temp ^ (temp >>> 32));
    result = 31 * result + (randomSeed != null ? randomSeed.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "NameGeneratorOptions{" +
        "genderWeight=" + genderWeight +
        ", randomSeed=" + randomSeed +
        '}';
  }
}
