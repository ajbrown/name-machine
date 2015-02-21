package org.ajbrown.namemachine;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

/**
 * Unit Test for {@link Name}
 * @author A.J. Brown <aj@ajbrown.org>
 */
public class NameGeneratorTest {


    NameGenerator generator;

    @Before
    public void setUp() {
        generator = new NameGenerator();
    }

    @Test
    public void randomNamesAreGeneratedWithoutGender() {

        List<Name> names = generator.generateNames( 1000 );

        assert names.size() == 1000;

        //Note that there's a rare chance that this will fail even when things are working just fine.  We randomly
        // determine whether a name will be male or female on each pass, so it's plausible (but unlikely) that names
        // end up being the same gender.
        int males = 0;
        int females = 0;
        for( Name name : names ) {
            if( name.getGender() == Gender.FEMALE ) {
                females++;
            } else {
                males++;
            }
        }

        // We should get both males and females.
        assertTrue( "Expected number of male names to be greater than 0", males > 0 );
        assertTrue( "Expected number of female names to be greater than 0", females > 0 );
    }

    @Test
    public void randomNamesAreGeneratedWithGender() {

        List<Name> femaleNames = generator.generateNames( 1000, Gender.FEMALE );
        List<Name> maleNames   = generator.generateNames( 1900, Gender.MALE );

        assertEquals( 1000, femaleNames.size() );
        assertEquals( 1900, maleNames.size() );

        // All of the female names should be female
        for( Name name : femaleNames ) {
            assertEquals( name.getGender(), Gender.FEMALE );
        }

        // All of the male names should be male
        for( Name name : maleNames ) {
            assertEquals( name.getGender(), Gender.MALE );
        }
    }
}
