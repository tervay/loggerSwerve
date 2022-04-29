package frc.robot.utility;

import lombok.Getter;
import lombok.ToString;

@ToString
public class FieldRelativeSpeed {
  @Getter private double xMetersPerSecond;
  @Getter private double yMetersPerSecond;
  @Getter private double rotRadiansPerSecond;

  public FieldRelativeSpeed(double x, double y, double rot) {
    this.xMetersPerSecond = x;
    this.yMetersPerSecond = y;
    this.rotRadiansPerSecond = rot;
  }
}
