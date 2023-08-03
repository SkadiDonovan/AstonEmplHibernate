package ru.skadidonovan.hibernatehw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skadidonovan.hibernatehw.models.Employee;
import ru.skadidonovan.hibernatehw.models.Position;
import ru.skadidonovan.hibernatehw.services.PositionService;

import java.util.List;


@RestController
@RequestMapping("/api/position")
public class PositionController {

    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping
    public List<Position> getAll() {
        return positionService.getAll();
    }

    @GetMapping("/{id}")
    public Position getOne(@PathVariable long id) {
        return positionService.getOne(id);
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> create(@RequestBody Position position) {
        if(positionService.save(position))
            return ResponseEntity.ok(HttpStatus.OK);
        else
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@RequestBody Position position,
                                             @PathVariable long id) {
        positionService.update(id, position);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable long id) {
        positionService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/employees")
    public List<Employee> getPositionEmployees(@RequestParam String positionName){
        return positionService.getPositionEmployees(positionName);
    }
}
