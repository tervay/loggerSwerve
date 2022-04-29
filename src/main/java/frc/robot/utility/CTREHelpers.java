package frc.robot.utility;

import com.ctre.phoenix.sensors.Pigeon2_Faults;
import java.util.ArrayList;

public class CTREHelpers {
  public enum UsablePigeonFaults {
    HARDWARE_FAULT,
    API_ERROR,
    UNDER_VOLTAGE,
    RESET_DURING_EN,
    SATURATED_ROT_VELOCITY,
    SATURATED_ACCEL,
    SATURATED_MAG,
    BOOT_INTO_MOTION,
    MAGNETOMETER_FAULT,
    GYRO_FAULT,
    ACCEL_FAULT;
  }

  public static ArrayList<UsablePigeonFaults> translatePigeonFaults(Pigeon2_Faults ctreFaults) {
    return new ArrayList<UsablePigeonFaults>() {
      {
        if (ctreFaults.APIError) {
          add(UsablePigeonFaults.API_ERROR);
        }
      }
    };
  }
}
