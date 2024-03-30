public class SizeCalculatorVisitor implements FileSystemVisitor {
    private double totalSize = 0;
    private double directorySize = 0;

    @Override
    public void visit(File file) {
        totalSize += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        totalSize += directorySize;
    }

    public double getTotalSize() {
        return totalSize;
    }
}
