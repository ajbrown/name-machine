package org.ajbrown.namemachine;

/**
 * An instance of a generated name.  Name's are immutable.
 *
 * @author A.J. Brown <aj@ajbrown.org>
 */
public class Name {

    private final String firstName;
    private final String lastName;
    private final Gender gender;

    public Name(String firstName, String lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.gender    = gender;
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
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Name name = (Name) o;

        if (firstName != null ? !firstName.equals(name.firstName) : name.firstName != null)
            return false;

        if (gender != name.gender)
            return false;

        if (lastName != null ? !lastName.equals(name.lastName) : name.lastName != null)
            return false;

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
