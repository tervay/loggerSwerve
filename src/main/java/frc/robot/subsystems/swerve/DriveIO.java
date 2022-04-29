package frc.robot.subsystems.swerve;

import frc.robot.Util.UsablePigeonFaults;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

public interface DriveIO {
  public static class DriveIOInputs implements LoggableInputs {
    public double gyroYawPositionRadians = 0.0;
    public double gyroPitchPositionRadians = 0.0;
    public double gyroRollPositionRadians = 0.0;
    public List<UsablePigeonFaults> pigeonFaults = new ArrayList<>();

    @Override
    public void toLog(LogTable table) {
      table.put("gyroYawPositionRadians", gyroYawPositionRadians);
      table.put("gyroPitchPositionRadians", gyroPitchPositionRadians);
      table.put("gyroRollPositionRadians", gyroRollPositionRadians);
      table.put("pigeonFaults", pigeonFaults.stream().map(e -> e.name()).toArray(String[]::new));
    }

    @Override
    public void fromLog(LogTable table) {
      gyroYawPositionRadians = table.getDouble("gyroYawPositionRadians", gyroYawPositionRadians);
      gyroPitchPositionRadians =
          table.getDouble("gyroPitchPositoinRadians", gyroPitchPositionRadians);
      gyroRollPositionRadians = table.getDouble("gyroRollPositionRadians", gyroRollPositionRadians);
      pigeonFaults =
          Arrays.stream(table.getStringArray("pigeonFaults", new String[] {}))
              .map(s -> UsablePigeonFaults.valueOf(s))
              .collect(Collectors.toList());
    }
  }

  public void updateInputs(DriveIOInputs inputs);
}
