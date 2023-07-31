package pl.programming4you.lectures5.lecture9.Task19;

import java.util.Objects;

public class Computer implements HasCpu {
    private final int RAMGb;
    private final int cores;
    private final int baseClockMhz;
    private final GraphicsCardType GPU;

    public int getRAMGb() {
        return RAMGb;
    }

    public GraphicsCardType getGPU() {
        return GPU;
    }

    @Override
    public String toString() {
        return "Computer: RAM=" + RAMGb + "GB, CPU=" + cores + " cores, Clock Speed=" + baseClockMhz + "MHz, Graphics=" + GPU;
    }

    @Override
    public int hashCode() {
        return Objects.hash(RAMGb, cores, baseClockMhz, GPU);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return RAMGb == computer.RAMGb &&
                cores == computer.cores &&
                baseClockMhz == computer.baseClockMhz &&
                GPU == computer.GPU;
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
