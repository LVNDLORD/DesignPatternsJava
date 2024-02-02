import java.util.ArrayList;
import java.util.List;

class Organization implements OrganizationalUnit {

    private String name;
    private List<OrganizationalUnit> units;

    public Organization(String name) {
        this.name = name;
        this.units = new ArrayList<>();
    }

    @Override
    public void add(OrganizationalUnit unit) {
        units.add(unit);
    }

    @Override
    public void remove(OrganizationalUnit unit) {
        units.remove(unit);
    }

    @Override
    public void printXML() {
        System.out.println("<Organization name=\"" + name + "\">");
        for (OrganizationalUnit unit : units) {
            unit.printXML();
        }
        System.out.println("</Organization>");
    }

    @Override
    public double getSalary() {
        double total = 0;
        for (OrganizationalUnit unit : units) {
            total += unit.getSalary();
        }
        return total;
    }
}
