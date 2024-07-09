package com.ckproj.ems_backend.controller;

import com.ckproj.ems_backend.dto.EmployeeDto;
import com.ckproj.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto)
    {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long emplyeeId)
    {
        EmployeeDto getById = employeeService.getEmployeeById(emplyeeId);
        return new ResponseEntity<>(getById, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee()
    {
        List<EmployeeDto> getAll = employeeService.getAllEmployees();
        return new ResponseEntity<>(getAll, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long emplyeeId, @RequestBody EmployeeDto updateEmployee)
    {
        EmployeeDto employeeDto = employeeService.updatedEmployee(emplyeeId, updateEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmppoyee(@PathVariable("id") Long employeeId)
    {
        employeeService.deleteEmployee(employeeId);
        return  ResponseEntity.ok("Employee Deleted Successfully");
    }
}
