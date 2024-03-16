package bg.softuni.springdataautomappingobjects.data.service;

import bg.softuni.springdataautomappingobjects.data.entity.dto.EmployeeDTO;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> findInfoForBornBefore(LocalDate beforeYear);
}
