package frc.robot.subsystems.swerve;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder
public class SwerveModuleConfig {
  @Getter @NonNull private String name;
  @Getter @NonNull private Integer driveMotorCANId;
  @Getter @NonNull private Integer steeringMotorCANId;
  @Getter @NonNull private Integer absoluteEncoderPort;
  @Getter @NonNull private Double drivingKS;
  @Getter @NonNull private Double drivingKV;
  @Getter @NonNull private Double drivingKP;
  @Getter @NonNull private Double steeringKP;
  @Getter @NonNull private Double encoderOffset;
}
