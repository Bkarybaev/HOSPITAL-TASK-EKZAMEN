package hospital.dao;

import hospital.models.Hospital;
import hospital.models.Patient;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface HospitalDao {
    String addHospital(Hospital hospital);
    Optional<Hospital> findHospitalById(Long id);
    List<Hospital> getAllHospital();
    Optional<Patient> getAllPatientFromHospital(Long id);
    String deleteHospitalById(Long id);
    Map<String, Hospital> getAllHospitalByAddress(String address);
}
