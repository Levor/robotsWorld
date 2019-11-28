package vv.robotsWorld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vv.robotsWorld.domain.Job;
import vv.robotsWorld.repo.JobRepo;

import java.util.List;

@RestController
@RequestMapping("job")
public class JobsController {

    private final JobRepo jobRepo;

    @Autowired
    public JobsController(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    @GetMapping
    public List<Job> listjob(){
        return jobRepo.findAll();
    }
    @GetMapping("{id}")
    public Job getOne(@PathVariable("id") Job job){
        return job;
    }

    @PostMapping
    public Job create(@RequestBody Job job){
        return jobRepo.save(job);
    }
}
