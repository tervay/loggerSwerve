package frc.robot.subsystems.swerve;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj.RobotController;
import frc.robot.Constants.SwerveConstants;

public class SwerveModuleIOSparkMaxThriftyEncoder implements SwerveModuleIO {
  private CANSparkMax driving, steering;
  private AnalogEncoder absoluteEncoder;

  private SwerveModuleConfig config;

  public SwerveModuleIOSparkMaxThriftyEncoder(SwerveModuleConfig config) {
    this.config = config;
    driving = new CANSparkMax(config.getDriveMotorCANId(), MotorType.kBrushless);
    steering = new CANSparkMax(config.getSteeringMotorCANId(), MotorType.kBrushless);

    driving.restoreFactoryDefaults();
    driving
        .getEncoder()
        .setPositionConversionFactor(
            1.0 / SwerveConstants.kDrivingRatio * SwerveConstants.kWheelRadiusMeters * Math.PI);
    driving
        .getEncoder()
        .setVelocityConversionFactor(
            1.0
                / SwerveConstants.kDrivingRatio
                * SwerveConstants.kWheelRadiusMeters
                * Math.PI
                * 60);

    steering.restoreFactoryDefaults();
    steering.getEncoder().setPositionConversionFactor(2 * Math.PI);
    steering.getEncoder().setVelocityConversionFactor(2 * Math.PI * 60);

    absoluteEncoder = new AnalogEncoder(config.getAbsoluteEncoderPort());
  }

  @Override
  public void updateInputs(SwerveModuleIOInputs inputs) {
    inputs.absoluteEncoderPositionRadians = absoluteEncoder.get();
    inputs.absoluteEncoderReadingVolts =
        absoluteEncoder.getAbsolutePosition() * RobotController.getVoltage5V();

    inputs.drivingAppliedVolts = driving.getAppliedOutput() * RobotController.getBatteryVoltage();
    inputs.drivingCurrentAmps = driving.getOutputCurrent();
    inputs.drivingPositionMeters = driving.getEncoder().getPosition();
    inputs.drivingTemperatureCelsius = driving.getMotorTemperature();
    inputs.drivingVelocityMetersPerSec = driving.getEncoder().getVelocity();

    inputs.steeringAppliedVolts = steering.getAppliedOutput() * RobotController.getBatteryVoltage();
    inputs.steeringCurrentAmps = steering.getOutputCurrent();
    inputs.steeringPositionRadians = steering.getEncoder().getPosition();
    inputs.steeringTemperatureCelsius = steering.getMotorTemperature();
    inputs.steeringVelocityRadiansPerSec = steering.getEncoder().getVelocity();
  }

  @Override
  public SwerveModuleConfig getConfig() {
    return config;
  }

  @Override
  public void setSteeringVoltage(double volts) {
    steering.setVoltage(volts);
  }

  @Override
  public void setDrivingVoltage(double volts) {
    driving.setVoltage(volts);
  }
}
