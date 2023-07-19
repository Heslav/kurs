package pl.programming4you.lectures5.lecture9.Task19;


public class Laptop extends Computer {
    double batteryCapacityWh;

    public Laptop(int RAMGb, int cores, int baseClockMhz, GraphicsCardType GPU, double batteryCapacityWh) {
        super(RAMGb, cores, baseClockMhz, GPU);
        this.batteryCapacityWh = batteryCapacityWh;
    }

    public double getBatteryCapacityWh() {
        return batteryCapacityWh;
    }

    @Override
    public String toString() {
        return "Laptop: RAM=" + RAMGb + "GB, CPU=" + cores + " cores, Clock Speed=" + baseClockMhz + "MHz, Graphics=" + GPU
                + ", Battery capacity: " + batteryCapacityWh;
    }

}


