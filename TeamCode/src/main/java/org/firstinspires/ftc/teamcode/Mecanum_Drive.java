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


    @Override
    public void runOpMode() throws InterruptedException {
        leftFront = hardwareMap.dcMotor.get("leftFront");
        rightFront = hardwareMap.dcMotor.get("rightFront");
        leftRear = hardwareMap.dcMotor.get("leftRear");
        rightRear = hardwareMap.dcMotor.get("rightRear");

        // Setting the motors to go reverse
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftRear.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        rightFront.setPower ((gamepad1.left_stick_y)+(gamepad1.left_stick_x)+(gamepad1.right_stick_y)-(gamepad1.right_stick_x));
        leftFront.setPower (-(gamepad1.left_stick_y)+(gamepad1.left_stick_x)-(gamepad1.right_stick_y)-(gamepad1.right_stick_x));
        rightRear.setPower ((gamepad1.left_stick_y)+(gamepad1.left_stick_x)+(gamepad1.right_stick_y)+(gamepad1.right_stick_x));
        leftRear.setPower (-(gamepad1.left_stick_y)+(gamepad1.left_stick_x)-(gamepad1.right_stick_y)+(gamepad1.right_stick_x));
    }
}