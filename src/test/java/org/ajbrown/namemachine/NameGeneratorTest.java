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

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
