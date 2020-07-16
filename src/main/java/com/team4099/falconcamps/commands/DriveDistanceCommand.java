package com.team4099.falconcamps.commands;

import com.team4099.falconcamps.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveDistanceCommand extends CommandBase {
    private double distanceMeters;
    private Drivetrain drivetrain;
    private PIDController left = new PIDController(0, 0, 0);
    private PIDController right = new PIDController(0, 0, 0);
    public DriveDistanceCommand(double distanceMeters, Drivetrain drivetrain) {
        this.distanceMeters = distanceMeters;
        this.drivetrain = drivetrain;
    }
    @Override
    public void execute(){
       double LeftPower = left.calculate(drivetrain.LeftDistance(), distanceMeters);
       double RightPower = right.calculate(drivetrain.RightDistance(), distanceMeters);
       drivetrain.setLRPower(LeftPower, RightPower);
    }
}