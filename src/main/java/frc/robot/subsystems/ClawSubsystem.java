package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//servo based class... lowk might get ditced bc he servo might not be strong enough
    public class ClawSubsystem extends SubsystemBase{

        private Servo m_claw = new Servo(/*get the channel when the servo is in*/1);

        public ClawSubsystem(){
            m_claw.set(0);
        }

        public Command clawCommand(){
            if(m_claw.getPosition() == 0){
                return this.run(() -> this.m_claw.set(1));
            }else{
                return this.run(() -> this.m_claw.set(0));
            }
        }
    }