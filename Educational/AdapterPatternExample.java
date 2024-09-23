class PowerOutlet220V {
    public String supplyPower() {
        return "220V power supplied";
    }
}

class Device110V {
    public void usePower(String power) {
        if ("110V power supplied".equals(power)) {
            System.out.println("Device is using 110V power");
        } else {
            System.out.println("Cannot use this power supply");
        }
    }
}

class PowerAdapter {
    private PowerOutlet220V outlet;

    public PowerAdapter(PowerOutlet220V outlet) {
        this.outlet = outlet;
    }

    public String convertPower() {
        return "110V power supplied";
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        PowerOutlet220V outlet = new PowerOutlet220V();
        PowerAdapter adapter = new PowerAdapter(outlet);
        Device110V device = new Device110V();

        String power = adapter.convertPower();
        device.usePower(power);
    }
}
