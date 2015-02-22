package org.ajbrown.namemachine;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit Test for {@link org.ajbrown.namemachine.Name}
 *
 * @author A.J. Brown <aj@ajbrown.org>
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
