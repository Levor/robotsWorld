package vv.robotsWorld.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vv.robotsWorld.domain.Job;

public interface JobRepo extends JpaRepository<Job, Long> {
}
