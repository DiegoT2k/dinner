package it.project.dinner.service.impl;

import it.project.dinner.dto.AttendanceDTO;
import it.project.dinner.model.Dinner;
import it.project.dinner.model.DinnerAttendance;
import it.project.dinner.model.User;
import it.project.dinner.repository.DinnerAttendanceRepository;
import it.project.dinner.repository.DinnerRepository;
import it.project.dinner.repository.UserRepository;
import it.project.dinner.service.DinnerAttendanceService;
import it.project.dinner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DinnerAttendanceServiceImpl implements DinnerAttendanceService {

    @Autowired
    private DinnerAttendanceRepository attendanceRepository;

    @Autowired
    private DinnerRepository dinnerRepository;

    @Autowired
    private UserRepository userRepository;

    public void addAttendance(Long dinnerId, Long userId) {
        Dinner dinner = dinnerRepository.findById(dinnerId)
                .orElseThrow(() -> new RuntimeException("Dinner not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        DinnerAttendance attendance = new DinnerAttendance();
        attendance.setDinner(dinner);
        attendance.setUser(user);

        attendanceRepository.save(attendance);
    }

    public void removeAttendance(Long dinnerId, Long userId) {

        DinnerAttendance attendance = attendanceRepository
                .findByDinnerIdAndUserId(dinnerId, userId)
                .orElseThrow(() -> new RuntimeException("Attendance not found"));

        attendanceRepository.delete(attendance);
    }

    public List<AttendanceDTO> getAttendance(Long dinnerId) {
        return attendanceRepository.findByDinnerId(dinnerId)
                .stream()
                .map(a -> {
                    AttendanceDTO dto = new AttendanceDTO();
                    dto.setId(a.getId());
                    dto.setUserId(a.getUser().getId());
                    dto.setUserName(a.getUser().getName());
                    dto.setUserSurname(a.getUser().getSurname());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}


