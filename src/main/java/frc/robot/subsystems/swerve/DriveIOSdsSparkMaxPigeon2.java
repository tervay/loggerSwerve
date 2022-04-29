package frc.robot.subsystems.swerve;

import com.ctre.phoenix.sensors.Pigeon2;
import com.ctre.phoenix.sensors.Pigeon2_Faults;
import edu.wpi.first.math.geometry.Rotation2d;
import frc.robot.Constants.CANIDs;
import frc.robot.Util;

public class DriveIOSdsSparkMaxPigeon2 implements DriveIO {

  Pigeon2 gyro = new Pigeon2(CANIDs.pigeon);

  @Override
  public void updateInputs(DriveIOInputs inputs) {
    inputs.gyroPitchPositionRadians = Rotation2d.fromDegrees(gyro.getPitch()).getRadians();
    inputs.gyroRollPositionRadians = Rotation2d.fromDegrees(gyro.getRoll()).getRadians();
    inputs.gyroYawPositionRadians = Rotation2d.fromDegrees(gyro.getYaw()).getRadians();

    Pigeon2_Faults faults = new Pigeon2_Faults();
    gyro.getFaults(faults);
    inputs.pigeonFaults = Util.translatePigeonFaults(faults);
  }
}
