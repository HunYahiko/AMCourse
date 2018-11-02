package utm.endava.lesson2.Model;

public class Player {
    private String name;
    private String firstName;
    private String lastName;

    public Player(String name) {
        this.name = name;
    }

    public Player() {
        this.name = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void splitFirstAndLastName() {
        String[] names = name.split(" ");
        firstName = names[0];
        lastName = names[1];
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String printName() {
        return lastName + ", " + firstName;
    }

    @Override
    public String toString() {
        return name;
    }
}
