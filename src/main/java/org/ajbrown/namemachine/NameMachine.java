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
 * NameMachine generates random names.
 *
 * @author A.J. Brown <a href="mailto:aj@ajbrown.org">aj@ajbrown.org</a>
 */
public class NameMachine
{

  /**
   * Generate random names and send them to standard out.
   *
   * @param args first argument is the number of names to generate, the second argument is the gender
   */
  public static void main(final String[] args) {

    if (args.length == 0) {
      System.err.print("You must specify the number of names to generate");
    }

    Integer count = Integer.parseInt(args[0]);

    if (count < 0) {
      throw new IllegalArgumentException("Name count must be a positive number.");
    }

    Gender gender = null;

    if (args.length > 1) {
      // gender can be specified in either plural or singular form.
      gender = Gender.valueOf(args[1].replace("s", "").toUpperCase());
    }

    NameGenerator generator = new NameGenerator();
    for (int i = 0; i < count; i++) {
      outputName(generator.generateName(gender));
    }

    System.exit(0);
  }

  /**
   * Formats a name and outputs it to STD_OUT
   *
   * @param name the name to format.
   */
  protected static void outputName(final Name name) {
    System.out.println(name.toString());
  }
}
