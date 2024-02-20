package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp()
public class Joystick extends OpMode {
    DcMotor droneMotor, leftFront, leftBack, rightFront, rightBack;
    public double forward;
    public double strafe;
    public double turn;
    public double rightFrontPower;
    public double leftFrontPower;
    public double rightBackPower;
    public double leftBackPower;
    public void init(){
        droneMotor = hardwareMap.dcMotor.get("droneMotor");
        leftFront = hardwareMap.dcMotor.get("leftFront");
        leftBack = hardwareMap.dcMotor.get("leftBack");
        rightFront = hardwareMap.dcMotor.get("rightFront");
        rightBack = hardwareMap.dcMotor.get("rightBack");
        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    public void loop(){
        if(gamepad1.a){
            droneMotor.setPower(1);
        } else {
            droneMotor.setPower(0);
        }
        forward = -gamepad1.left_stick_y;
        strafe = gamepad1.left_stick_x;
        turn = gamepad1.right_stick_x;
        leftBackPower = (forward - strafe + turn);
        rightBackPower = (forward + strafe - turn);
        rightFrontPower = (forward - strafe - turn);
        leftFrontPower = (forward + strafe + turn);
        leftBack.setPower(leftBackPower);
        rightBack.setPower(rightBackPower);
        leftFront.setPower(leftFrontPower);
        rightFront.setPower(rightFrontPower);
    }
}
