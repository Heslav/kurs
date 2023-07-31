package pl.programming4you.lectures5.lecture9.Task19;


import java.util.Objects;

public class Laptop extends Computer {
    private final double batteryCapacityWh;

    public Laptop(int RAMGb, int cores, int baseClockMhz, GraphicsCardType GPU, double batteryCapacityWh) {
        super(RAMGb, cores, baseClockMhz, GPU);
        this.batteryCapacityWh = batteryCapacityWh;
    }

    public double getBatteryCapacityWh() {
        return batteryCapacityWh;
    }

    // return super
    @Override
    public String toString() {
        return "Laptop: RAM=" + super.getRAMGb() + "GB, CPU=" + super.getCores() + " cores, Clock Speed=" +
                super.getBaseClockMhz() + "MHz, Graphics=" + super.getGPU() + ", Battery capacity: " +
                batteryCapacityWh;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), batteryCapacityWh);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Laptop laptop = (Laptop) o;
        return batteryCapacityWh == laptop.batteryCapacityWh;
    }

}
