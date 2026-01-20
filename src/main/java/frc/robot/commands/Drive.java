package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;

import com.ctre.phoenix6.controls.VoltageOut;

import edu.wpi.first.wpilibj2.command.Command;

public class Drive extends Command {
    @SuppressWarnings("PMD.UnusedPrivateField")
    private final DriveSubsystem driveSubsystem;

    public VoltageOut voltage = new VoltageOut(0);
    public double volts = 0;

    public Drive(DriveSubsystem m_DriveSubsystem) {
        this.driveSubsystem = m_DriveSubsystem;
        addRequirements(m_DriveSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        driveSubsystem.drive(voltage, volts);
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return false;
    }

}