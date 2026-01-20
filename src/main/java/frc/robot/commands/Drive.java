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
    private final DoubleSupplier voltsSupplier;
    private final VoltageOut voltage = new VoltageOut(0);

    public Drive(DriveSubsystem subsystem, DoubleSupplier voltsSupplier) {
        this.driveSubsystem = subsystem;
        this.voltsSupplier = voltsSupplier;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        driveSubsystem.drive(voltage, voltsSupplier.getAsDouble());
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