public class Computer {
    protected String processor;
    protected int ramInGB;
    protected String hardDrive;
    protected String graphicsCard;
    protected String operatingSystem;

    public Computer(String processor, int ramInGB, String hardDrive, String graphicsCard, String operatingSystem) {
        this.processor = processor;
        this.ramInGB = ramInGB;
        this.hardDrive = hardDrive;
        this.graphicsCard = graphicsCard;
        this.operatingSystem = operatingSystem;
    }

    // setters to change components after the computer is built
    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setRamInGB(int ramInGB) {
        this.ramInGB = ramInGB;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        return "processor: " + processor + "\n" +
                "RAM: " + ramInGB + "GB\n" +
                "Hard Drive: " + hardDrive + "\n" +
                "graphics Card: " + graphicsCard + "\n" +
                "Operating System: " + operatingSystem + "\n";
    }
}
