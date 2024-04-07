public class GamingComputerBuilder implements ComputerBuilder {
    private final Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer("", 0, "", "", "");
    }

    @Override
    public void buildProcessor(String processor) {
        computer.processor = processor;
    }

    @Override
    public void buildRAM(int sizeGB) {
        computer.ramInGB = sizeGB;
    }

    @Override
    public void buildHardDrive(String hardDrive) {
        computer.hardDrive = hardDrive;
    }

    @Override
    public void buildGraphicsCard(String graphicsCard) {
        computer.graphicsCard = graphicsCard;
    }

    @Override
    public void buildOperatingSystem(String operatingSystem) {
        computer.operatingSystem = operatingSystem;
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}

