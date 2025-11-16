package org.firstinspires.ftc.teamcode;

public abstract class Sensor {
    protected String name;
    protected boolean controlHub;
    protected boolean expensionHub;
    protected int port;
    protected boolean isActive;

    public Sensor(String name, int port, boolean controlHub, boolean expensionHub) {
        this.name = name;
        this.port = port;
        this.controlHub = controlHub;
        this.expensionHub = expensionHub;
        this.isActive = false;
    }
    public void activate() {
        this.isActive = true;
        System.out.println(this.name + " sensor activated.");
    }

    public void deactivate() {
        this.isActive = false;
        System.out.println(this.name + " sensor deactivated.");
    }

    public abstract void read();

}
