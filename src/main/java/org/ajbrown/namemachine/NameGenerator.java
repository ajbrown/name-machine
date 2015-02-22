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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * NameGenerator can generate realistic American male and female full names. It uses U.S. Census data to ensure that
 * more common names will appear more often.  Names are returned as a list of {@link Name}.
 *
 * @author A.J. Brown <aj@ajbrown.org>
 */
public class NameGenerator {
    private static final Logger LOG = Logger.getLogger(NameGenerator.class.getName());

    private static final String FEMALE_NAMES_FILE = "/org/ajbrown/namemachine/dist.female.first.txt";
    private static final String MALE_NAMES_FILE   = "/org/ajbrown/namemachine/dist.male.first.txt";
    private static final String SURNAMES_FILE     = "/org/ajbrown/namemachine/dist.all.last.txt";

    private final Random random = new Random();

    private TreeMap<Float,String> surnames;
    private TreeMap<Float,String> females;
    private TreeMap<Float,String> males;

    public NameGenerator() {

        try {
            surnames = loadNames( SURNAMES_FILE );
            females  = loadNames( FEMALE_NAMES_FILE );
            males    = loadNames( MALE_NAMES_FILE );
        } catch ( IOException e ) {
            LOG.log( Level.WARNING, "IOException while loading names files.  You may not get any results!", e );
        }
    }

    /**
     * Generate names for a specific gender.
     *
     * @param count the number of names to generate.
     * @param gender the gender for all names. If null, names will be generated for both genders.
     * @return random names.
     */
    public List<Name> generateNames( int count, Gender gender ) {
        if( gender == null ) {
            return generateNames( count );
        }

        List<Name> names = new ArrayList<>(count);
        TreeMap<Float,String> source = gender == Gender.FEMALE ? females : males;

        for( int i = 0; i < count; i++ ) {
            names.add( new Name( pickName( source ), pickName( surnames ), gender ) );
        }

        return names;
    }

    /**
     * Generate random names for both genders.  Female names are slightly more likely to occur.
     * @param count the number of names to generate.
     * @return random names.
     */
    public List<Name> generateNames( int count ) {
        List<Name> names = new ArrayList<>(count);

        for( int i = 0; i < count; i++ ) {

            // 48 percent chance for a male name
            if( random.nextFloat() * 100 > 48 ) {
                names.add( new Name( pickName( females ), pickName( surnames), Gender.FEMALE ) );
            } else {
                names.add( new Name( pickName( males ), pickName( surnames ), Gender.MALE ) );
            }
        }

        return names;
    }

    /**
     * Capitalize only the first letter of the given string.
     *
     * @param line the line of text to capitalize.
     * @return the capitalized line.
     */
    private String capitalize(String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1).toLowerCase();
    }

    /**
     * Pick a name from the specified TreeMap based on a random number.
     * @return the picked name.
     */
    private String pickName( TreeMap<Float,String> map ) {
        assert !map.isEmpty();

        Float key = null;
        while( key == null ) {
            try {
                key = map.ceilingKey( random.nextFloat() * 100 );
            } catch( NullPointerException ignored ) {
                //Do nothing.
            }
        }

        return capitalize( map.get(key) );
    }

    /**
     * Loads all of the names in the given file into a TreeMap keyed by the name's cumulative frequency.
     * @param file the resource path to the text file containing the names to load.
     * @return a TreeMap of all names in the file.
     * @throws IOException
     */
    private TreeMap<Float,String> loadNames( final String file ) throws IOException {
        TreeMap<Float,String> names = new TreeMap<>();
        InputStream is = NameGenerator.class.getResourceAsStream( file );

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line = reader.readLine();
            while (line != null) {
                String[] fields = line.split("\\s+");
                names.put(Float.parseFloat(fields[2]), fields[0]);
                line = reader.readLine();
            }
        }

        return names;
    }
}
