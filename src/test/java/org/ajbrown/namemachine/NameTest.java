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

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit Test for {@link org.ajbrown.namemachine.Name}
 *
 * @author A.J. Brown <a href="mailto:aj@ajbrown.org">aj@ajbrown.org</a>
 */
public class NameTest {

    @Test
    public void nameReturnsConstructedValues() {

        Name name1 = new Name( "Buzz", "Aldrin", Gender.MALE );

        assertEquals("Buzz", name1.getFirstName());
        assertEquals("Aldrin", name1.getLastName());
        assertEquals(Gender.MALE, name1.getGender());

        Name name2 = new Name( "Sally", "Ride", Gender.FEMALE );

        assertEquals("Sally", name2.getFirstName());
        assertEquals("Ride", name2.getLastName());
        assertEquals(Gender.FEMALE, name2.getGender());
    }

    @Test
    public void toStringReturnsFullName() {
        Name name = new Name( "James", "Lovell", Gender.MALE );

        assertEquals("James Lovell", name.toString());
    }

    @Test
    public void testEquals() {
        Name name1 = new Name( "Jack", "Swigert", Gender.MALE );
        Name name2 = new Name( "Jack", "Swigert", Gender.MALE );

        Name name3 = new Name( "Jack", "Swigert", Gender.FEMALE );
        Name name4 = new Name( "Jane", "Swigert", Gender.FEMALE );
        Name name5 = new Name( "Jane", "Shipley", Gender.FEMALE );

        assertTrue( name1.equals( name2 ) );
        assertFalse( name1.equals( name3 ) );
        assertFalse( name1.equals( name4 ) );
        assertFalse( name4.equals( name5 ) );
    }
}
