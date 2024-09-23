class Light {
    public void on() {
        System.out.println("Light is on");
    }

    public void off() {
        System.out.println("Light is off");
    }
}

class AirConditioner {
    public void on() {
        System.out.println("Air Conditioner is on");
    }

    public void off() {
        System.out.println("Air Conditioner is off");
    }
}

class SecuritySystem {
    public void activate() {
        System.out.println("Security System activated");
    }

    public void deactivate() {
        System.out.println("Security System deactivated");
    }
}

class HomeAutomationFacade {
    private Light light;
    private AirConditioner ac;
    private SecuritySystem security;

    public HomeAutomationFacade() {
        light = new Light();
        ac = new AirConditioner();
        security = new SecuritySystem();
    }

    public void enterHome() {
        light.on();
        ac.on();
        security.deactivate();
    }

    public void leaveHome() {
        light.off();
        ac.off();
        security.activate();
    }
}

public class FacadePatternExample {
    public static void main(String[] args) {
        HomeAutomationFacade home = new HomeAutomationFacade();

        home.enterHome();
        home.leaveHome();
    }
}
