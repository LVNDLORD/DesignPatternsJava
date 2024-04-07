public class Main {
    public static void main(String[] args) {
        ComputerDirector director = new ComputerDirector();

        // Build Gaming PC
        GamingComputerBuilder gamingBuilder = new GamingComputerBuilder();
        director.constructComputer(gamingBuilder, "Intel i9", 32, "1TB SSD", "Nvidia RTX 3080", "Windows 10");
        Computer gamingComputer = gamingBuilder.getComputer();
        System.out.println("Gaming Computer Configuration:");
        System.out.println(gamingComputer);

        // Build Office PC
        OfficeComputerBuilder officeBuilder = new OfficeComputerBuilder();
        director.constructComputer(officeBuilder, "Intel Celeron", 4, "128GB HDD", "AMD Radeon RX 550", "Windows 10");
        Computer officeComputer = officeBuilder.getComputer();
        System.out.println("\nOffice Computer Configuration:");
        System.out.println(officeComputer);

        // Update Office pc
        officeComputer.setHardDrive("256GB SSD");
        officeComputer.setRamInGB(16);
        officeComputer.setProcessor("Intel i5");
        System.out.println("\nUpdated Office Computer Configuration:");
        System.out.println(officeComputer);
    }
}
