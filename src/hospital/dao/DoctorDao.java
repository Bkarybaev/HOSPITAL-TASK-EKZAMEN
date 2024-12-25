package hospital.dao;

import hospital.models.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorDao {
    Optional<Doctor>  findDoctorById(Long id);

    // Department‘ти id менен табып, анан Doctor‘лорду листтеги айдилери менен табып анан ошол табылган Department'ге табылган Doctor'лорду кошуп коюнунуз
    String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId);
    List<Doctor> getAllDoctorsByHospitalId(Long id);
    List<Doctor> getAllDoctorsByDepartmentId(Long id);
}
