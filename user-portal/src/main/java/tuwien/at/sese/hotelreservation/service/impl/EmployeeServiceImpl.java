//package tuwien.at.sese.hotelreservation.service.impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import tuwien.at.sese.hotelreservation.model.Employee;
//import tuwien.at.sese.hotelreservation.repository.EmployeeRepository;
//import tuwien.at.sese.hotelreservation.service.EmployeeService;
//
///**
// * @author Abbas ULUSOY 
// *
// */
//@Service
//public class EmployeeServiceImpl implements EmployeeService {
//
//    @Autowired
//    private EmployeeRepository repository;
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public Employee create(Employee employee) {
//        return repository.save(employee);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public Employee delete(Long id) {
//        Employee Employee = findById(id);
//        if (Employee != null) {
//            repository.delete(Employee);
//        }
//        return Employee;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public List<Employee> findAll() {
//        return repository.findAll();
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public Employee findById(Long id) {
//        return repository.findOne(id);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public Employee update(Employee employee) {
//        return repository.save(employee);
//    }
//}
