package frc.robot.subsystems.swerve;

import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

public class DriveIO {
  public static class DriveIOInputs implements LoggableInputs {
    public double gyroYawPositionRadians = 0.0;
    public double gyroYawVelocityRadiansPerSec = 0.0;
    public double gyroPitchPositoinRadians = 0.0;
    public double gyroRollPositionRadians = 0.0;

    @Override
    public void toLog(LogTable table) {
      table.put("gyroYawPositionRadians", gyroYawPositionRadians);
      table.put("gyroYawVelocityRadiansPerSec", gyroYawVelocityRadiansPerSec);
      table.put("gyroPitchPositoinRadians", gyroPitchPositoinRadians);
      table.put("gyroRollPositionRadians", gyroRollPositionRadians);
    }

    @Override
    public void fromLog(LogTable table) {
      gyroYawPositionRadians = table.getDouble("gyroYawPositionRadians", gyroYawPositionRadians);
      gyroYawVelocityRadiansPerSec =
          table.getDouble("gyroYawVelocityRadiansPerSec", gyroYawVelocityRadiansPerSec);
      gyroPitchPositoinRadians =
          table.getDouble("gyroPitchPositoinRadians", gyroPitchPositoinRadians);
      gyroRollPositionRadians = table.getDouble("gyroRollPositionRadians", gyroRollPositionRadians);
    }
  }
}
