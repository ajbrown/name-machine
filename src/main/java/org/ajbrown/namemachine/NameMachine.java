package org.ajbrown.namemachine;

import java.util.ArrayList;
import java.util.List;

/**
 * NameMachine generates random names.
 *
 * @author A.J. Brown <aj@ajbrown.org>
 */
public class NameMachine {

    /**
     * Generate random names and send them to standard out.
     * @param args first argument is the number of names to generate, the second argument is the gender
     */
    public static void main( String[] args ) {

        if ( args.length == 0 ) {
            System.err.print( "You must specify the number of names to generate" );
        }

        Integer count = Integer.parseInt( args[0] );

        if( count < 0 ) {
            throw new IllegalArgumentException( "Name count must be a positive number." );
        }

        Gender gender = null;

        if( args.length > 1 ) {
            // gender can be specified in either plural or singular form.
            gender = Gender.valueOf( args[1].replace( "s", "" ).toUpperCase() );
        }


        NameGenerator generator = new NameGenerator();
        outputNames( generator.generateNames( count, gender ) );

        System.exit(0);
    }

    /**
     * Outputs the the list of names to the console.
     * @param names
     */
    protected static void outputNames( List<Name> names ) {
        for( Name name : names ) {
            System.out.println( name.toString() );
        }
    }
}
