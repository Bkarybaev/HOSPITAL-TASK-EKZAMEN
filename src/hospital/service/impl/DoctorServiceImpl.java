package hospital.service.impl;

import hospital.dao.impl.DoctorDaoImpl;
import hospital.models.Doctor;
import hospital.service.DoctorService;
import hospital.service.GenericService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DoctorServiceImpl implements DoctorService, GenericService<Doctor> {

    DoctorDaoImpl doctorDao = new DoctorDaoImpl();

    @Override
    public Optional<Doctor>  findDoctorById(Long id) {
        try {
            return doctorDao.findDoctorById(id);
        } catch (Exception e) {
            System.out.println("Failed to find doctor by ID: " + e.getMessage());
            return Optional.of(null);
        }
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        try {
            return doctorDao.assignDoctorToDepartment(departmentId, doctorsId);
        } catch (Exception e) {
            return "Failed to assign doctors to department: " + e.getMessage();
        }
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        try {
            return doctorDao.getAllDoctorsByHospitalId(id);
        } catch (Exception e) {
            System.out.println("Failed to get doctors by hospital ID: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        try {
            return doctorDao.getAllDoctorsByDepartmentId(id);
        } catch (Exception e) {
            System.out.println("Failed to get doctors by department ID: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public String add(Long hospitalId, Doctor doctor) {
        try {
            return doctorDao.add(hospitalId, doctor);
        } catch (Exception e) {
            return "Failed to add doctor: " + e.getMessage();
        }
    }

    @Override
    public void removeById(Long id) {
        try {
            doctorDao.removeById(id);
            System.out.println("Doctor removed successfully.");
        } catch (Exception e) {
            System.out.println("Failed to remove doctor: " + e.getMessage());
        }
    }

    @Override
    public String updateById(Long id, Doctor doctor) {
        try {
            return doctorDao.updateById(id, doctor);
        } catch (Exception e) {
            return "Failed to update doctor: " + e.getMessage();
        }
    }



}
