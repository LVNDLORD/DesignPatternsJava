public class Main {
    public static void main(String[] args) {
        Organization organization = new Organization("IBM");

        Department hrDepartment = new Department("HR");
        Employee johnDoe = new Employee("John Doe", 50000);
        Employee janeSmith = new Employee("Jane Smith", 57000);
        Employee olafHarrison = new Employee("Olaf Harrison", 60000);

        hrDepartment.add(johnDoe);
        hrDepartment.add(janeSmith);
        hrDepartment.add(olafHarrison);

        Department engineeringDepartment = new Department("Engineering");
        Employee bobSanders = new Employee("Bob Sanders", 60000);
        Employee aliceJohnson = new Employee("Alice Johnson", 62000);

        engineeringDepartment.add(bobSanders);
        engineeringDepartment.add(aliceJohnson);

        organization.add(hrDepartment);
        organization.add(engineeringDepartment);
        hrDepartment.remove(janeSmith); // excluding from the printing


        organization.printXML();

        System.out.println("Total Salary: " + organization.getSalary());
    }
}
