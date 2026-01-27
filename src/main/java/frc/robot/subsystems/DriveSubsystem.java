package frc.robot.subsystems;

import static edu.wpi.first.units.Units.Amps;

import com.ctre.phoenix6.CANBus;
import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.TorqueCurrentConfigs;
import com.ctre.phoenix6.configs.VoltageConfigs;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.units.measure.Voltage;
import edu.wpi.first.wpilibj2.command.SubsystemBase;



public class DriveSubsystem extends SubsystemBase{
    
    public CANBus rio = new CANBus("rio");

    private final TalonFX motorL = new TalonFX(1, rio);
    private final TalonFX motorR = new TalonFX(4, rio);
    

    public DriveSubsystem() {
        TalonFXConfiguration talonFXConfiguration = new TalonFXConfiguration()
        .withCurrentLimits(
            new CurrentLimitsConfigs()
            .withStatorCurrentLimit(Amps.of(70))
            .withStatorCurrentLimitEnable(true)
            )
        .withVoltage(
            new VoltageConfigs()
            .withPeakForwardVoltage(edu.wpi.first.units.Units.Volts.of(10))
            .withPeakReverseVoltage(edu.wpi.first.units.Units.Volts.of(-10))
        );

        motorL.getConfigurator().apply(talonFXConfiguration);
        motorR.getConfigurator().apply(talonFXConfiguration);
    }

    public void drive(VoltageOut voltage, double lVolts, double rVolts) {
        motorL.setControl(voltage.withOutput(-lVolts));
        motorR.setControl(voltage.withOutput(rVolts));

        //System.out.println(motorL.getPosition());
        //System.out.println(motorR.getPosition());
    }

    
    public void stop() {
        motorL.setNeutralMode(NeutralModeValue.Brake);
        motorL.setControl(new VoltageOut(0).withOutput(0));
        motorR.setNeutralMode(NeutralModeValue.Brake);
        motorR.setControl(new VoltageOut(0).withOutput(0));
    }
    
}