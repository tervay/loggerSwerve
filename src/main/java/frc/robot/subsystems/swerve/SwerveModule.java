package frc.robot.subsystems.swerve;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.swerve.SwerveModuleIO.SwerveModuleIOInputs;
import org.littletonrobotics.junction.Logger;

public class SwerveModule extends SubsystemBase {
  SwerveModuleIO io;
  SwerveModuleIOInputs inputs;

  private PIDController drivePIDController, steeringPIDController;
  private SimpleMotorFeedforward driveFeedforward;

  public SwerveModule(SwerveModuleIO io) {
    this.io = io;
    inputs = new SwerveModuleIOInputs();

    drivePIDController = new PIDController(io.getConfig().getDrivingKP(), 0, 0);
    steeringPIDController = new PIDController(io.getConfig().getSteeringKP(), 0, 0);
    steeringPIDController.enableContinuousInput(-Math.PI, Math.PI);
    driveFeedforward =
        new SimpleMotorFeedforward(io.getConfig().getDrivingKS(), io.getConfig().getDrivingKV());
  }

  public SwerveModuleState getState() {
    return new SwerveModuleState(
        inputs.drivingVelocityMetersPerSec, new Rotation2d(inputs.absoluteEncoderPositionRadians));
  }

  @Override
  public void periodic() {
    io.updateInputs(inputs);
    Logger.getInstance().processInputs("Swerve Module (" + io.getConfig().getName() + ")", inputs);
  }

  public void setDesiredState(SwerveModuleState desiredState) {
    SwerveModuleState state =
        SwerveModuleState.optimize(
            desiredState, new Rotation2d(inputs.absoluteEncoderPositionRadians));

    double driveOutput =
        drivePIDController.calculate(
            inputs.drivingVelocityMetersPerSec, state.speedMetersPerSecond);
    double driveFF = driveFeedforward.calculate(state.speedMetersPerSecond);
    io.setDrivingVoltage(driveOutput + driveFF);

    double steeringOutput =
        steeringPIDController.calculate(
            inputs.absoluteEncoderPositionRadians, state.angle.getRadians());
    io.setSteeringVoltage(steeringOutput);
  }
}
