/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

public class SensorSubsystem extends SubsystemBase {
  public static SensorSubsystem m_SensorSubsystem = new SensorSubsystem();
  /**
   * Creates a new SensorSubsystem.
   */
    CANSparkMax motor1 = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
    CANEncoder encoder1 = new CANEncoder(motor1);
    
    Ultrasonic sonic = new Ultrasonic(2, 3);
    sonic.setAutomaticMode(true);
    
    double calculatedDistanceCount = (sonic.getRangeInches())*(1/2*Math.PI*5)*(1024);

  //  double countGoal;
  

  public void setMotorSpeed(double speed) {
    motor1.set(speed);
  }

  public double getPos(){
    return encoder1.getPosition(); 
  }

  public double getCount() {
    return calculatedDistanceCount;

  } 

 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

