package it.project.dinner.repository;

import it.project.dinner.model.DinnerAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface DinnerAttendanceRepository extends JpaRepository<DinnerAttendance, Long> {
    List<DinnerAttendance> findByDinnerId(Long dinnerId);
    Optional<DinnerAttendance> findByDinnerIdAndUserId(Long dinnerId, Long userId);

}

