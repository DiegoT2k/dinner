package it.project.dinner.controller;

import it.project.dinner.dto.AttendanceDTO;
import it.project.dinner.service.DinnerAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/attendance")
@CrossOrigin(origins = {
        "http://localhost:3000",
        "https://dinners-fe.vercel.app/"
})
public class DinnerAttendanceController {

    @Autowired
    private DinnerAttendanceService attendanceService;

    @PostMapping("/add")
    public ResponseEntity<Void> add(@RequestBody Map<String, Long> body) {
        Long dinnerId = body.get("dinnerId");
        Long userId = body.get("userId");

        attendanceService.addAttendance(dinnerId, userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byDinner/{dinnerId}")
    public ResponseEntity<List<AttendanceDTO>> getByDinner(@PathVariable Long dinnerId) {
        return ResponseEntity.ok(attendanceService.getAttendance(dinnerId));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> remove(@RequestBody Map<String, Long> body){

        attendanceService.removeAttendance(body.get("dinnerId"),body.get("userId"));
        return ResponseEntity.ok("Removed");
    }
}
