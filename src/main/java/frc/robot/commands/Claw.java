package frc.robot.commands;
import frc.robot.subsystems.ClawSubsystem;
import com.ctre.phoenix6.controls.VoltageOut;

import edu.wpi.first.wpilibj2.command.Command;
import java.util.function.DoubleSupplier;

public class Claw extends Command{
    private ClawSubsystem claw;
    public Claw(ClawSubsystem subsystem){
        this.claw = subsystem;
        addRequirements(this.claw);
    }

    public void initialize(){
        
    }

    public void execute(){
        claw.close();
    }

    public void end(){
        claw.open();
    }

    public boolean isFinished(boolean terminate){
        claw.open();
        return false;
    }
}
