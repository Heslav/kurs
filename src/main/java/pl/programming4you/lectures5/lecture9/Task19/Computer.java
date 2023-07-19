package pl.programming4you.lectures5.lecture9.Task19;

public class Computer implements HasCpu {
    int RAMGb;
    int cores;
    int baseClockMhz;
    GraphicsCardType GPU;

    @Override
    public String toString() {
        return "Computer: RAM=" + RAMGb + "GB, CPU=" + cores + " cores, Clock Speed=" + baseClockMhz + "MHz, Graphics=" + GPU;
    }

    public Computer(int RAMGb, int cores, int baseClockMhz, GraphicsCardType GPU) {
        this.RAMGb = RAMGb;
        this.cores = cores;
        this.baseClockMhz = baseClockMhz;
        this.GPU = GPU;
    }

    @Override
    public int getCores() {
        return cores;
    }

    @Override
    public int getBaseClockMhz() {
        return baseClockMhz;
    }
}
