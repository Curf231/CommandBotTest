package frc.robot.commands;
import frc.robot.subsystems.DriveSubsystem;
import com.ctre.phoenix6.controls.VoltageOut;
import edu.wpi.first.wpilibj2.command.Command;
import java.util.function.DoubleSupplier;

/**
 * Drive command that applies a voltage (from a DoubleSupplier) to the drive motors.
 * Uses the command-based framework properly by declaring requirements and stopping
 * the motors when the command ends.
 */
public class Drive extends Command {
    private final DriveSubsystem driveSubsystem;
    private final DoubleSupplier LvoltsSupplier;
    private final DoubleSupplier RvoltsSupplier;
    private final VoltageOut voltage = new VoltageOut(0);

    public Drive(DriveSubsystem subsystem, DoubleSupplier LvoltsSupplier, DoubleSupplier RvoltsSupplier) {
        this.driveSubsystem = subsystem;
        this.LvoltsSupplier = LvoltsSupplier;
        this.RvoltsSupplier = RvoltsSupplier;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        if((RvoltsSupplier.getAsDouble() > -0.36 && RvoltsSupplier.getAsDouble() < -0.12)){
            driveSubsystem.drive(voltage, LvoltsSupplier.getAsDouble(), 0);
        }else{
            driveSubsystem.drive(voltage, LvoltsSupplier.getAsDouble(), RvoltsSupplier.getAsDouble());
        }
        //System.out.println("L: " + LvoltsSupplier.getAsDouble() + 
        //    "\nr: " + RvoltsSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}