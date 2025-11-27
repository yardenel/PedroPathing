package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;



public class servo
{
    private CRServo CRservo;

    public void init(HardwareMap hwmap)
    {
        CRservo = hwmap.get(CRServo.class,"servo");
    }

    public void setServo(double power)
    {
        CRservo.setPower(power);
    }
}
