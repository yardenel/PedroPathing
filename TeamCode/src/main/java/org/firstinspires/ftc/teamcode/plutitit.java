package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;

@TeleOp
public class plutitit extends OpMode
{
    private Limelight3A limelight;
    private IMU imu;
    private servo CRservo = new servo();
    private ElapsedTime timer = new ElapsedTime();  // Timer to track elapsed time
    int txMax = 6;
    int x = 0;

    @Override
    public void init()
    {
        CRservo.init(hardwareMap);
        limelight = hardwareMap.get(Limelight3A.class,"limelight");
        limelight.pipelineSwitch(9);
    }

    @Override
    public void start()
    {
        limelight.start();
        timer.reset();  // Start the timer when the opmode starts
    }

    @Override
    public void loop()
    {
        LLResult llResult = limelight.getLatestResult();
        long staleness = llResult.getStaleness();
        double tx = llResult.getTx();
        double ty = llResult.getTy();
        double ta = llResult.getTa();

        if (staleness < 100)
        { // Less than 100 milliseconds old
            telemetry.addData("Data", "Good (" + staleness + " ms)");
        }
        else
        {
            telemetry.addData("Data", "Old (" + staleness + " ms)");
        }

        if (llResult != null && llResult.isValid() && staleness < 100)
        {
            Pose3D botPos = llResult.getBotpose();
            telemetry.addData("tx", tx);
            telemetry.addData("ty", ty);
            telemetry.addData("ta", ta);
            telemetry.addData("pose", botPos.toString());

            if (tx > txMax)
            {
                CRservo.setServo(-0.1);   // Turn servo on
            }
            else if (tx < -txMax)
            {
                CRservo.setServo(0.1);
            }
            else if (tx < txMax && tx > -txMax)
            {
                CRservo.setServo(0);
            }
        }
        else  if (timer.seconds() > 0.3)
        {

            CRservo.setServo(0);  // Turn servo off after 500ms
            timer.reset();  // Reset timer after sleeping

        }

        telemetry.update();  // Update telemetry
    }
}