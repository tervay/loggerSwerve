package frc.robot.subsystems.swerve;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SwerveConstants;
import frc.robot.subsystems.swerve.DriveIO.DriveIOInputs;
import frc.robot.utility.FieldRelativeSpeed;
import org.littletonrobotics.junction.Logger;

public class Drive extends SubsystemBase {

  DriveIO io;
  DriveIOInputs inputs = new DriveIOInputs();

  SwerveDriveKinematics kinematics =
      new SwerveDriveKinematics(
          new Translation2d(0.381, 0.381),
          new Translation2d(0.381, -0.381),
          new Translation2d(-0.381, 0.381),
          new Translation2d(-0.381, -0.381));

  SwerveModule frontRight, frontLeft, backLeft, backRight;

  public Drive(
      DriveIO driveIO,
      SwerveModuleIO frontLeftIO,
      SwerveModuleIO frontRightIO,
      SwerveModuleIO backLeftIO,
      SwerveModuleIO backRightIO) {
    io = driveIO;
    frontRight = new SwerveModule(frontRightIO);
    frontLeft = new SwerveModule(frontLeftIO);
    backLeft = new SwerveModule(backLeftIO);
    backRight = new SwerveModule(backRightIO);
  }

  @Override
  public void periodic() {
    io.updateInputs(inputs);
    Logger.getInstance().processInputs("Drive", inputs);
  }

  public void setFieldRelativeSpeeds(FieldRelativeSpeed speed) {
    SwerveModuleState[] states =
        kinematics.toSwerveModuleStates(
            ChassisSpeeds.fromFieldRelativeSpeeds(
                speed.getXMetersPerSecond(),
                speed.getYMetersPerSecond(),
                speed.getRotRadiansPerSecond(),
                new Rotation2d(inputs.gyroYawPositionRadians)));

    SwerveDriveKinematics.desaturateWheelSpeeds(states, SwerveConstants.kMaxSpeedMetersPerSecond);
    frontLeft.setDesiredState(states[0]);
    frontRight.setDesiredState(states[1]);
    backLeft.setDesiredState(states[2]);
    backRight.setDesiredState(states[3]);
  }
}
