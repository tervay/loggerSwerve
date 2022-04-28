package frc.robot.subsystems.swerve;

import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

public interface SwerveModuleIO {
  public static class SwerveModuleIOInputs implements LoggableInputs {
    public double drivingPositionMeters = 0.0;
    public double drivingVelocityMetersPerSec = 0.0;
    public double drivingAppliedVolts = 0.0;
    public double drivingCurrentAmps = 0.0;
    public double drivingTemperatureCelsius = 0.0;

    public double steeringPositionRadians = 0.0;
    public double steeringVelocityRadiansPerSec = 0.0;
    public double steeringAppliedVolts = 0.0;
    public double steeringCurrentAmps = 0.0;
    public double steeringTemperatureCelsius = 0.0;

    public double absoluteEncoderPositionRadians = 0.0;
    public double absoluteEncoderReadingVolts = 0.0;

    @Override
    public void toLog(LogTable table) {
      table.put("drivingPositionMeters", drivingPositionMeters);
      table.put("drivingVelocityMetersPerSec", drivingVelocityMetersPerSec);
      table.put("drivingAppliedVolts", drivingAppliedVolts);
      table.put("drivingCurrentAmps", drivingCurrentAmps);
      table.put("drivingTemperatureCelsius", drivingTemperatureCelsius);
      table.put("steeringPositionRadians", steeringPositionRadians);
      table.put("steeringVelocityRadiansPerSec", steeringVelocityRadiansPerSec);
      table.put("steeringAppliedVolts", steeringAppliedVolts);
      table.put("steeringCurrentAmps", steeringCurrentAmps);
      table.put("steeringTemperatureCelsius", steeringTemperatureCelsius);
      table.put("absoluteEncoderPositionRadians", absoluteEncoderPositionRadians);
      table.put("absoluteEncoderReadingVolts", absoluteEncoderReadingVolts);
    }

    @Override
    public void fromLog(LogTable table) {
      drivingPositionMeters = table.getDouble("drivingPositionMeters", drivingPositionMeters);
      drivingVelocityMetersPerSec =
          table.getDouble("drivingVelocityMetersPerSec", drivingVelocityMetersPerSec);
      drivingAppliedVolts = table.getDouble("drivingAppliedVolts", drivingAppliedVolts);
      drivingCurrentAmps = table.getDouble("drivingCurrentAmps", drivingCurrentAmps);
      drivingTemperatureCelsius =
          table.getDouble("drivingTemperatureCelsius", drivingTemperatureCelsius);
      steeringPositionRadians = table.getDouble("steeringPositionRadians", steeringPositionRadians);
      steeringVelocityRadiansPerSec =
          table.getDouble("steeringVelocityRadiansPerSec", steeringVelocityRadiansPerSec);
      steeringAppliedVolts = table.getDouble("steeringAppliedVolts", steeringAppliedVolts);
      steeringCurrentAmps = table.getDouble("steeringCurrentAmps", steeringCurrentAmps);
      steeringTemperatureCelsius =
          table.getDouble("steeringTemperatureCelsius", steeringTemperatureCelsius);
      absoluteEncoderPositionRadians =
          table.getDouble("absoluteEncoderPositionRadians", absoluteEncoderPositionRadians);
      absoluteEncoderReadingVolts =
          table.getDouble("absoluteEncoderReadingVolts", absoluteEncoderReadingVolts);
    }
  }

  public void updateInputs(SwerveModuleIOInputs inputs);

  // public void setDesiredState(SwerveModuleState desiredState);
  public void setSteeringVoltage(double volts);

  public void setDrivingVoltage(double volts);

  public SwerveModuleConfig getConfig();
}
