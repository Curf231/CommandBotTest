package frc.robot.subsystems;

import com.ctre.phoenix6.CANBus;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;



public class DriveSubsystem extends SubsystemBase{
    
    CANBus rio = new CANBus("rio");

    private final TalonFX motorL = new TalonFX(0, rio);
    //private final TalonFX motorR = new TalonFX(1, rio);
    

    public DriveSubsystem() {
        TalonFXConfiguration talonFXConfiguration = new TalonFXConfiguration();
        motorL.getConfigurator().apply(talonFXConfiguration);
        //motorR.getConfigurator().apply(talonFXConfiguration);
    }

    public void drive(VoltageOut voltage, double volts) {
        motorL.setControl(voltage.withOutput(volts));
        //motorR.setControl(voltage.withOutput(volts));
    }

    
    public void stop() {
        motorL.setNeutralMode(NeutralModeValue.Brake);
        motorL.setControl(new VoltageOut(0).withOutput(0));
        //motorR.setNeutralMode(NeutralModeValue.Brake);
    }

    @Override
    public void periodic() {
        
    }
}