public class Employee implements OrganizationalUnit {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Cannot add to an employee
    @Override
    public void add(OrganizationalUnit unit) {
    }

    // Cannot remove from an employee
    @Override
    public void remove(OrganizationalUnit unit) {
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void printXML() {
        System.out.println("\t\t<Employee name=\"" + name + "\" salary=\"" + salary + "\" />");
    }
}
