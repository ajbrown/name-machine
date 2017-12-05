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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;


/**
 * A unit test for {@link NameGeneratorOptions}.
 *
 * @author ajbrown
 */
public class NameGeneratorOptionsTest {

    @Test
    public void testGenderWeightField() {
        NameGeneratorOptions options = new NameGeneratorOptions();

        options.setGenderWeight( 48.8 );
        assertEquals( 48.8, options.getGenderWeight(), 0 );

        options.setGenderWeight( 55.0 );
        assertEquals( 55.0, options.getGenderWeight(), 0 );
    }

    @Test(expected=IllegalArgumentException.class)
    public void testGenderWeightMustBePositive() {
        NameGeneratorOptions options = new NameGeneratorOptions();
        options.setGenderWeight( -1 );
    }

    @Test
    public void testGenderWeightDefault() {
        NameGeneratorOptions options = new NameGeneratorOptions();
        assertEquals( NameGeneratorOptions.DEFAULT_GENDER_WEIGHT, options.getGenderWeight(), 0 );
    }

    @Test
    public void testRandomSeedField() {
        NameGeneratorOptions options = new NameGeneratorOptions();

        options.setRandomSeed( 123L );
        assertEquals( 123L, options.getRandomSeed().longValue() );

        options.setRandomSeed( 456L );
        assertEquals( 456L, options.getRandomSeed().longValue() );
    }

    @Test
    public void testRandomSeedDefault() {
        NameGeneratorOptions options = new NameGeneratorOptions();
        assertNull( options.getRandomSeed() );
    }

    @Test
    public void testEquals() {
        NameGeneratorOptions a = new NameGeneratorOptions();
        NameGeneratorOptions b = new NameGeneratorOptions();
        assertEquals( a, b );

        a.setGenderWeight( 15 );
        b.setGenderWeight( 30 );
        assertNotEquals( a, b );

        a.setGenderWeight( 30 );
        assertEquals( a, b );

        a.setRandomSeed( 123L );
        assertNotEquals( a, b );

        b.setRandomSeed( 456L );
        assertNotEquals( a, b );

        b.setRandomSeed( 123L );
        assertEquals( a, b );
    }
}
