import java.util.ArrayList;
import java.util.List;

public class Department implements OrganizationalUnit {
    private String name;
    private List<OrganizationalUnit> units;

    public Department(String name) {
        this.name = name;
        this.units = new ArrayList<>();

    }

    @Override
    public void add(OrganizationalUnit unit) {
        units.add(unit);
    }

    @Override
    public void remove(OrganizationalUnit Unit) {
        units.remove(Unit);
    }

    @Override
    public double getSalary() {
        double total = 0;
        for (OrganizationalUnit unit : units) {
            total += unit.getSalary();
        }
        return total;
    }

    @Override
    public void printXML() {
        System.out.println("\t<Department name=\"" + name + "\">");
        for (OrganizationalUnit unit : units) {
            unit.printXML();
        }
        System.out.println("\t</Department>");
    }
}
