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
 * An instance of a generated name.  Name's are immutable.
 *
 * @author A.J. Brown <a href="mailto:aj@ajbrown.org">aj@ajbrown.org</a>
 */
public class Name
{

  private final String firstName;

  private final String lastName;

  private final Gender gender;

  public Name(final String firstName, final String lastName, final Gender gender) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
  }

  public final Gender getGender() {
    return gender;
  }

  public final String getFirstName() {
    return firstName;
  }

  public final String getLastName() {
    return lastName;
  }

  @Override
  public String toString() {
    return this.firstName + " " + this.lastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Name name = (Name) o;

    if (firstName != null ? !firstName.equals(name.firstName) : name.firstName != null) {
      return false;
    }

    if (gender != name.gender) {
      return false;
    }

    if (lastName != null ? !lastName.equals(name.lastName) : name.lastName != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = firstName != null ? firstName.hashCode() : 0;
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (gender != null ? gender.hashCode() : 0);
    return result;
  }
}
