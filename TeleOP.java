package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.ColorSensor;
//import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class TeleOP extends LinearOpMode {

    /* Movement Motors */

    private DcMotor leftFrontMotor;

    private DcMotor rightFrontMotor;

    private DcMotor leftBackMotor;

    private DcMotor rightBackMotor;

    /* Sensors */

//    private ColorSensor colorSensor;

    /* Servos */

//    private Servo servo;

    @Override
    public void runOpMode() {
        this.configureMotors();
//        this.configureServos();
//        this.configureDigitalSensors();

        this.waitForStart();

        this.telemetry.addData("Status", "Initialized");
        this.telemetry.update();

        while(this.opModeIsActive()) {
            this.leftFrontMotor.setPower(this.gamepad1.left_stick_y + this.gamepad1.left_stick_x);
            this.leftBackMotor.setPower(this.gamepad1.left_stick_y + this.gamepad1.left_stick_x);
            this.rightFrontMotor.setPower(-this.gamepad1.left_stick_y + this.gamepad1.left_stick_x);
            this.rightBackMotor.setPower(-this.gamepad1.left_stick_y + this.gamepad1.left_stick_x);

//            this.servo.setPosition(0.5);

//            this.telemetry.addData("Color Sensor (red): ", this.colorSensor.red());
//            this.telemetry.addData("Color Sensor (blue): ", this.colorSensor.blue());
//            this.telemetry.addData("Color Sensor (green): ", this.colorSensor.green());
            this.telemetry.update();
        }
    }

    private void configureMotors() {
        this.leftFrontMotor = hardwareMap.get(DcMotor.class, "leftFront");
        this.rightFrontMotor = hardwareMap.get(DcMotor.class, "rightFront");
        this.leftBackMotor = hardwareMap.get(DcMotor.class, "leftBack");
        this.rightBackMotor = hardwareMap.get(DcMotor.class, "rightBack");

        this.leftFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.rightFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.leftBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.rightBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

//    private void configureServos() {
//        this.servo = hardwareMap.get(Servo.class, "servo1");
//    }

//    private void configureDigitalSensors() {
//        this.colorSensor = hardwareMap.get(ColorSensor.class, "color");
//    }
}
