package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;
/**
 * Created by joegerhardstein on 9/23/18.
 */

//extremely important, needed to tell the phones where to place the program
@TeleOp(name = "tester", group = "2018Programs")


public class tester extends LinearOpMode {
    float speedMultiplier;
    private DcMotor firstJoint;
    private DcMotor secondJoint;
    private DcMotor thirdJoint;


    @Override
    public void runOpMode() throws InterruptedException {
        firstJoint = hardwareMap.dcMotor.get("firstJoint");
        secondJoint = hardwareMap.dcMotor.get("secondJoint");
        thirdJoint = hardwareMap.dcMotor.get("thirdJoint");
        speedMultiplier = 1;

        // start of actual program
            waitForStart();
            while (opModeIsActive()) {


                    while (opModeIsActive()) {

                        if (gamepad2.a){
                            firstJoint.setPower(1);
                        }
                        else firstJoint.setPower(0);

                        if (gamepad2.b){
                            firstJoint.setPower(-1);
                        }
                        else firstJoint.setPower(0);

                        if (gamepad2.x){
                            secondJoint.setPower(1);
                        }
                        else secondJoint.setPower(0);

                        if (gamepad2.y){
                            secondJoint.setPower(-1);
                        }
                        else secondJoint.setPower(0);

                        if (gamepad2.dpad_up){
                            thirdJoint.setPower(1);
                        }
                        else thirdJoint.setPower(0);

                        if (gamepad2.dpad_down){
                            thirdJoint.setPower(-1);
                        }
                        else thirdJoint.setPower(0);


                    }

                    }
}}
