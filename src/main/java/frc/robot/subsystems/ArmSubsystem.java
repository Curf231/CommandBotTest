package frc.robot.subsystems;
import java.util.function.DoubleSupplier;

import com.ctre.phoenix6.CANBus;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase{

    CANBus rio = new CANBus("rio");
    private final TalonFX armMotor = new TalonFX(6969, rio);//dont know what the motor id is yet

    public ArmSubsystem() {
        TalonFXConfiguration talonFXConfiguration = new TalonFXConfiguration();
        armMotor.getConfigurator().apply(talonFXConfiguration);
    }

    // Return a command that sets the motor output using a live DoubleSupplier value
    public Command armUpCommand(VoltageOut voltage, DoubleSupplier voltsSupplier) {
        return this.run(() -> this.armMotor.setControl(voltage.withOutput(voltsSupplier.getAsDouble())));
    }

    // Return a command that sets the motor output using a live DoubleSupplier value (inverted)
    public Command armDownCommand(VoltageOut voltage, DoubleSupplier voltsSupplier) {
        return this.run(() -> this.armMotor.setControl(voltage.withOutput(-voltsSupplier.getAsDouble())));
    }
}
