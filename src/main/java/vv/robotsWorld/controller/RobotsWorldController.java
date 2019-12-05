package vv.robotsWorld.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vv.robotsWorld.domain.Robot;
import vv.robotsWorld.repo.RobotRepo;

import java.util.List;

@RestController
@RequestMapping("robot")
public class RobotsWorldController {
    private final RobotRepo robotRepo;

    @Autowired
    public RobotsWorldController(RobotRepo robotRepo) {
        this.robotRepo = robotRepo;
    }

    @GetMapping
    public List<Robot> listrobot(){
        return robotRepo.findAll();
    }
    @GetMapping("{id}")
    public Robot getOne(@PathVariable("id") Robot robot){
        return robot;
    }

    @PostMapping
    public Robot create(@RequestBody Robot robot){
        robot.setStatus("Свободен");
        return robotRepo.save(robot);
    }

    @PutMapping("{id}")
    public Robot sent(@PathVariable("id") Robot robotFromDb,
                        @RequestBody Robot robot){
        BeanUtils.copyProperties(robot, robotFromDb, "id");
        return robotRepo.save(robotFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Robot robot){
        robotRepo.delete(robot);
    }

}
