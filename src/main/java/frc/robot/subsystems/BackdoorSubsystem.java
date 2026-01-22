package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BackdoorSubsystem extends SubsystemBase{
    TalonFX m_backdoor = new TalonFX(/*insert port when you get it*/67);
    TalonFXConfiguration configuration = new TalonFXConfiguration();
    private final VoltageOut voltage = new VoltageOut(0);
    public BackdoorSubsystem(){
        m_backdoor.getConfigurator().apply(configuration);
    }

    public Command openCommand(VoltageOut voltage, double volts){
        if(!voltage.equals(new VoltageOut(0))){
            return this.runOnce(() -> this.m_backdoor.setControl(voltage.withOutput(volts)));
        }else{
            return this.runOnce(() -> this.m_backdoor.setControl(voltage.withOutput(-volts)));
        }
    }

    public VoltageOut getVoltage(){
        return voltage;
    }
}
