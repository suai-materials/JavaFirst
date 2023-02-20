class Employee extends Person {

    private String company;

    public Employee(String name, String company) {

        super(name);
        this.company = company;

    }

    @Override
    public void display() {
        System.out.println("Name: " + getName());
        System.out.println("Works in " + company);
    }
}