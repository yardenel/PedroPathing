package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class servoIn extends OpMode
{

    CRServo servo; // <-- Declare here so all methods can use it

    @Override
    public void init()
    {
        servo = hardwareMap.get(CRServo.class, "servo");
    }

    @Override
    public void loop()
    {
        if (gamepad1.a)
        {
            servo.setPower(0.5);
        }
        else
        {
            servo.setPower(0);
        }

        if(gamepad1.b)
        {
            servo.setPower(-0.5);
        }
        else
        {
            servo.setPower(0);
        }
    }
}