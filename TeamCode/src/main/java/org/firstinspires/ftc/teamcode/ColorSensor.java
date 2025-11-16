package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;

public class ColorSensor extends Sensor {
    private NormalizedColorSensor sensor;
    private char detectedColor = 'e'; // 'g'=green 'p'=purple 'e'=empty

    public ColorSensor(String name, int port, boolean controlHub, boolean expensionHub, HardwareMap hardwareMap) {
        super(name, port, controlHub, expensionHub);
        sensor = hardwareMap.get(NormalizedColorSensor.class, name);
    }

    @Override
    public void read() {
        if (!isActive) return;

        NormalizedRGBA colors = sensor.getNormalizedColors();

        float r = colors.red;
        float g = colors.green;
        float b = colors.blue;

        // ---- Simple FTC-friendly purple/green detection ----
        if (r > 0.15 && b > 0.15 && g < 0.15) {
            detectedColor = 'p';
        }
        else if (g > r && g > b) {
            detectedColor = 'g';
        }
        else {
            detectedColor = 'e';
        }
    }
    // Get:
    // - color to insert
    // 
    public void insertAndUpdateSorter()


    public char getColor() {
        return detectedColor;
    }

}
