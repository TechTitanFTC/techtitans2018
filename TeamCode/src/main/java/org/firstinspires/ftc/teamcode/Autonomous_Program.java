package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by joegerhardstein on 10/14/18.
 */


@Autonomous(name = "Autonomous_Program")

public class Autonomous_Program extends LinearOpMode {
    DcMotor leftFront = null;
    DcMotor rightFront = null;
    DcMotor leftRear = null;
    DcMotor rightRear = null;
    DcMotor leftHook = null;
    DcMotor rightHook = null;
    Double leftmotorspeed = 1.0;
    Double rightmotorspeed = 1.0;
    ColorSensor colorSensor;


    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.clearAll();
        leftFront = hardwareMap.dcMotor.get("leftFront");
        rightFront = hardwareMap.dcMotor.get("rightFront");
        leftRear = hardwareMap.dcMotor.get("leftRear");
        rightRear = hardwareMap.dcMotor.get("rightRear");
        leftHook = hardwareMap.dcMotor.get("leftHook");
        rightHook = hardwareMap.dcMotor.get("rightHook");


        telemetry.addLine("At beginning");
        telemetry.update();

        // Setting the motors to go reverse
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftRear.setDirection(DcMotor.Direction.REVERSE);

        //reset encoder at beginning set to run to position
        leftHook.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftHook.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        rightHook.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightHook.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        waitForStart();

        leftHook.setTargetPosition(4500);
        rightHook.setTargetPosition(-4500);

        leftHook.setPower(1);
        rightHook.setPower(1);


        telemetry.addData("Encoder", leftHook.getCurrentPosition());
        telemetry.update();

        telemetry.addData("Encoder", rightHook.getCurrentPosition());
        telemetry.update();

        Thread.sleep(10000);
    }

        public void RobotMove (int leftCount, int rightCount) {
        boolean leftStop;
        boolean rightStop;
        boolean leftBackward;
        boolean rightBackward;

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBackward = (leftCount < 0);
        rightBackward = (rightCount < 0);

        if (leftBackward) {
            leftFront.setPower(-leftmotorspeed);
            leftRear.setPower(-leftmotorspeed); }
        else {
            leftFront.setPower(leftmotorspeed);
            leftRear.setPower(leftmotorspeed);
        }


        if (rightBackward) {
            rightFront.setPower(-rightmotorspeed);
            rightRear.setPower(-rightmotorspeed); }
        else {
            rightFront.setPower(rightmotorspeed);
            rightRear.setPower(rightmotorspeed);
        }

        do {
            telemetry.addData("Left Backward", leftBackward);
            telemetry.addData("Right Backward", rightBackward);
            telemetry.addData("left Position", leftFront.getCurrentPosition());
            telemetry.addData("Right Position", rightFront.getCurrentPosition());
            telemetry.update();
            leftStop = ((leftFront.getCurrentPosition() >= leftCount) && !leftBackward) || ((leftFront.getCurrentPosition() <= leftCount) && leftBackward);
            if (leftStop) {
                leftFront.setPower(0);
                leftRear.setPower(0);

            }
            rightStop = ((rightFront.getCurrentPosition() >= rightCount) && !rightBackward) || ((rightFront.getCurrentPosition() <= rightCount) && rightBackward);
            ;
            if (rightStop) {
                rightFront.setPower(0);
                rightRear.setPower(0);
            }


        } while (!leftStop || !rightStop);


    }





    }