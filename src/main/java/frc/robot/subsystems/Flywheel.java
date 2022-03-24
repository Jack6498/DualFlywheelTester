// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import io.github.oblarg.oblog.annotations.Config;
import io.github.oblarg.oblog.annotations.Log;

import static frc.robot.Constants.FlywheelConstants.*;

public class Flywheel extends SubsystemBase {


    //hardware declarations
  CANSparkMax flywheel1;
    CANSparkMax flywheel2;
    private final RelativeEncoder flywheel1Encoder;
    private final RelativeEncoder flywheel2Encoder;
    public SparkMaxPIDController frontPidController;
    public SparkMaxPIDController backPidController;
    double frontFlywheelSpeed;
    double backFlywheelSpeed;
    double number1;
    double number2;
    double velocity =1500;
  /** Creates a new Flywheel. */
  public Flywheel() {
    flywheel1 = new CANSparkMax(flyWheel1ID, MotorType.kBrushless);
    flywheel2 = new CANSparkMax(flyWheel2ID, MotorType.kBrushless);
    flywheel1Encoder = flywheel1.getEncoder();
    flywheel2Encoder = flywheel2.getEncoder();
    frontPidController = flywheel1.getPIDController();
    backPidController = flywheel2.getPIDController();

    frontPidController.setD(50);
    backPidController.setD(50);
   


  }
  

  @Log.Graph
  public double getFrontSpeed(double speed) {
    speed = flywheel1Encoder.getVelocity();
    return speed;
  }
  @Log.Graph
  public double getBackSpeed(double Speed) {
    Speed = flywheel2Encoder.getVelocity();
    return Speed;
  }
  @Config
  public void setFrontSpeed(){
  frontFlywheelSpeed = MathUtil.clamp(velocity, 1000, 6000);
  velocity =1500;
  frontPidController.setReference(1500, CANSparkMax.ControlType.kVelocity);
  }
  @Config
  public void setBackSpeed() {
    backFlywheelSpeed = MathUtil.clamp(velocity, 1000, 6000);
    velocity = 1500;
    backPidController.setReference(1500, CANSparkMax.ControlType.kVelocity);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    }
  }
