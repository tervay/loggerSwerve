package frc.robot.subsystems.swerve;

import lombok.Builder;
import lombok.Getter;

@Builder
public class SwerveModuleConfig {
  @Getter private String name;
  @Getter private int driveMotorCANId;
  @Getter private int steeringMotorCANId;
  @Getter private int absoluteEncoderPort;
  @Getter private double drivingKS;
  @Getter private double drivingKV;
  @Getter private double drivingKP;
  @Getter private double steeringKP;
  @Getter private double encoderOffset;
}
