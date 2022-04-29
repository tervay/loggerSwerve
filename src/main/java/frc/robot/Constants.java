// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.util.Units;
import frc.robot.subsystems.swerve.SwerveModuleConfig;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final class CANIDs {
    public static final int pigeon = 10;
  }

  public static final class SwerveConstants {
    public static final double kDrivingRatio = 6.75;
    public static final double kWheelRadiusMeters = Units.inchesToMeters(2.0);
    public static final double kMaxSpeedMetersPerSecond = Units.feetToMeters(16);

    public static final double kMaxAngularSpeedRadiansPerSecond = Units.degreesToRadians(360);

    public static final SwerveModuleConfig kFrontLeftModuleConfig =
        SwerveModuleConfig.builder()
            .name("Front Left")
            .absoluteEncoderPort(1)
            .driveMotorCANId(1)
            .steeringMotorCANId(2)
            .drivingKP(1.0)
            .drivingKS(1.0)
            .drivingKV(1.0)
            .steeringKP(1.0)
            .encoderOffset(1.0)
            .build();
    public static final SwerveModuleConfig kFrontRightModuleConfig =
        SwerveModuleConfig.builder()
            .name("Front Right")
            .absoluteEncoderPort(2)
            .driveMotorCANId(3)
            .steeringMotorCANId(4)
            .drivingKP(1.0)
            .drivingKS(1.0)
            .drivingKV(1.0)
            .steeringKP(1.0)
            .encoderOffset(1.0)
            .build();
    public static final SwerveModuleConfig kBackRightModuleConfig =
        SwerveModuleConfig.builder()
            .name("Back Right")
            .absoluteEncoderPort(3)
            .driveMotorCANId(5)
            .steeringMotorCANId(6)
            .drivingKP(1.0)
            .drivingKS(1.0)
            .drivingKV(1.0)
            .steeringKP(1.0)
            .encoderOffset(1.0)
            .build();
    public static final SwerveModuleConfig kBackLeftModuleConfig =
        SwerveModuleConfig.builder()
            .name("Back Left")
            .absoluteEncoderPort(4)
            .driveMotorCANId(7)
            .steeringMotorCANId(8)
            .drivingKP(1.0)
            .drivingKS(1.0)
            .drivingKV(1.0)
            .steeringKP(1.0)
            .encoderOffset(1.0)
            .build();
  }
}
