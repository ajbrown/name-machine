package org.ajbrown.namemachine;

import org.junit.Test;

/**
 * Unit Test for {@link org.ajbrown.namemachine.Name}
 *
 * @author A.J. Brown <aj@ajbrown.org>
 */
public class NameTest {


    @Test
    public void nameReturnsConstructedValues() {

        Name name1 = new Name( "Buzz", "Aldrin", Gender.MALE );

        assert "Buzz".equals( name1.getFirstName() );
        assert "Aldrin".equals( name1.getLastName() );
        assert Gender.MALE == name1.getGender();

        Name name2 = new Name( "Sally", "Ride", Gender.FEMALE );

        assert "Sally".equals( name2.getFirstName() );
        assert "Ride".equals( name2.getLastName() );
        assert Gender.FEMALE == name2.getGender();
    }

    @Test
    public void toStringReturnsFullName() {
        Name name = new Name( "James", "Lovell", Gender.MALE );

        assert "James Lovell".equals( name.toString() );
    }

}
