package bg.softuni.springdataautomappingobjects.data.service.impl;

import bg.softuni.springdataautomappingobjects.data.entity.Employee;
import bg.softuni.springdataautomappingobjects.data.entity.dto.EmployeeDTO;
import bg.softuni.springdataautomappingobjects.data.repository.EmployeeRepository;
import bg.softuni.springdataautomappingobjects.data.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EmployeeDTO> findInfoForBornBefore(LocalDate beforeYear) {
        List<Employee> employees = employeeRepository.findAllByBirthdayBeforeOrderBySalaryDesc(beforeYear);
        return employees.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private EmployeeDTO convertToDto(Employee employee) {
        EmployeeDTO dto = modelMapper.map(employee, EmployeeDTO.class);
        dto.setManagerLastName(employee.getManager() != null ? employee.getManager().getLastName() : null);
        return dto;
    }
}
