package vv.robotsWorld.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vv.robotsWorld.domain.Robot;

public interface RobotRepo extends JpaRepository<Robot, Long> {
}
