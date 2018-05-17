package first.example;

public class Customer {
    private String idCustomer;
    private String firstName;
    private String lastName;
    private int age;

    public Customer() { }

    public Customer(String idCustomer, String firstName, String lastName, int age) {
        this.idCustomer = idCustomer;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
