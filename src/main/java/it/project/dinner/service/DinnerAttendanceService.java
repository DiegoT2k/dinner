package it.project.dinner.service;

import it.project.dinner.dto.AttendanceDTO;
import it.project.dinner.model.DinnerAttendance;
import it.project.dinner.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DinnerAttendanceService {

    public void addAttendance(Long dinnerId, Long userId);

    public void removeAttendance(Long dinnerId, Long userId);

    public List<AttendanceDTO> getAttendance(Long dinnerId);
}


