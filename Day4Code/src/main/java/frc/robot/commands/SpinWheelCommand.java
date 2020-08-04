/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;


public class SpinWheelCommand extends CommandBase {
public SpinWheelCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_SensorSubsystem);
  } 
  
  //   double pos = RobotContainer.m_SensorSubsystem.encoder1.getPosition();
  //   double count = pos*1024;
 double countGoal = Constants.driveCount;
 
 // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_SensorSubsystem.setMotorSpeed(1);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    while((RobotContainer.m_SensorSubsystem.getPos())*1024 < countGoal) {
      RobotContainer.m_SensorSubsystem.setMotorSpeed(1);
    }
    RobotContainer.m_SensorSubsystem.setMotorSpeed(0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_SensorSubsystem.setMotorSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
