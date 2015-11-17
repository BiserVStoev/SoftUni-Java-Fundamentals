package Shop.Customers;

public class Customer {
    private String name;
    private int age;
    private double balance;

    public Customer(String name,  int age, double balance) {
        this.name = name;
        this.balance = balance;
        this.age = age;
    }



    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name.equals(" ")) {
            throw new IllegalArgumentException("The name of a person cannot be an empty string");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        if(age < 0) {
            throw new IllegalArgumentException("The age of a person cannot be a negative number");
        }
        this.age = age;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance < 0) {
            throw new IllegalArgumentException("The balance of a person cannot be a negative number");
        }
        this.balance = balance;
    }
}
