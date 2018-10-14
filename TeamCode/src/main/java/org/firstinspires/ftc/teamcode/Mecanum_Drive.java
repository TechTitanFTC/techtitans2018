package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "MecanumDriveTeleOp", group = "2018Programs")

/**
 * Created by Joe on 9/3/18.
 */

public class Mecanum_Drive extends LinearOpMode {
    private DcMotor leftFront;
    private DcMotor rightFront;
    private DcMotor leftRear;
    private DcMotor rightRear;
    float speedMultiplier;
    float leftmotorspeed;
    float rightmotorspeed;


    @Override
    public void runOpMode() throws InterruptedException {
        leftFront = hardwareMap.dcMotor.get("leftFront");
        rightFront = hardwareMap.dcMotor.get("rightFront");
        leftRear = hardwareMap.dcMotor.get("leftRear");
        rightRear = hardwareMap.dcMotor.get("rightRear");
        // Setting the motors to go reverse
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftRear.setDirection(DcMotor.Direction.REVERSE);
        speedMultiplier = 1;

        waitForStart();
        while (opModeIsActive()) {
            rightFront.setPower(-((gamepad1.left_stick_y) + (gamepad1.left_stick_x) + (gamepad1.right_stick_y) - (gamepad1.right_stick_x)));
            leftFront.setPower(-(gamepad1.left_stick_y) + (gamepad1.left_stick_x) - (gamepad1.right_stick_y) - (gamepad1.right_stick_x));
            rightRear.setPower(-((gamepad1.left_stick_y) + (gamepad1.left_stick_x) + (gamepad1.right_stick_y) + (gamepad1.right_stick_x)));
            leftRear.setPower(-(gamepad1.left_stick_y) + (gamepad1.left_stick_x) - (gamepad1.right_stick_y) + (gamepad1.right_stick_x));

            telemetry.addData("X Value", gamepad1.right_stick_x);
            telemetry.addData("Y Value", gamepad1. right_stick_y);
            telemetry.update();

            while (opModeIsActive()) {
                if (gamepad1.right_bumper) {
                    speedMultiplier = 1;
                }

                if (gamepad1.left_bumper) {
                    speedMultiplier = 3;


                }

                if (gamepad1.right_trigger > 0.5f) {
                    speedMultiplier = 2;
                }

                if (gamepad1.left_trigger > 0.5f) {
                    speedMultiplier = 5;
                }

                // Dividing the motor speed by the speed multiplier to get to the speeds in the four lines before
                leftmotorspeed = (-gamepad1.left_stick_y / speedMultiplier);
                rightmotorspeed = (gamepad1.right_stick_y / speedMultiplier);

                // Setting the left motor on the controller to push up to go forward
                // Setting the Right Motor on the controller to push down to go backward
                leftFront.setPower(leftmotorspeed);
                leftRear.setPower(leftmotorspeed);
                rightFront.setPower(-rightmotorspeed);
                rightRear.setPower(-rightmotorspeed);

            }
    }
}}

