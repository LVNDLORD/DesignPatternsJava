public class ComputerDirector {
    public void constructComputer(ComputerBuilder builder, String processor, int ramInGB, String hardDrive, String graphicsCard, String operatingSystem) {
        builder.buildProcessor(processor);
        builder.buildRAM(ramInGB);
        builder.buildHardDrive(hardDrive);
        builder.buildGraphicsCard(graphicsCard);
        builder.buildOperatingSystem(operatingSystem);
    }
}

