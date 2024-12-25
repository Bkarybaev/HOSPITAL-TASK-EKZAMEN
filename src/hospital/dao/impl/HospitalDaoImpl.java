package hospital.dao.impl;

import hospital.dao.HospitalDao;
import hospital.db.DataBase;
import hospital.models.Hospital;
import hospital.models.Patient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class HospitalDaoImpl implements HospitalDao {
    @Override
    public String addHospital(Hospital hospital) {
        DataBase.hospitals.add(hospital);
        return "Successfully added Hospital";
    }

    @Override
    public Optional<Hospital> findHospitalById(Long id) {
        return DataBase.hospitals.stream()
                .filter(hospital -> hospital.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Hospital> getAllHospital() {
        return DataBase.hospitals;
    }

    @Override
    public Optional<Patient>  getAllPatientFromHospital(Long id) {
       return DataBase.hospitals.stream()
                .filter(hospital -> hospital.getId().equals(id))
                .flatMap(hospital -> hospital.getPatients().stream())
                .findFirst();
    }

    @Override
    public String deleteHospitalById(Long id) {
        List<Hospital> list = findHospitalById(id).stream().toList();
        DataBase.hospitals.remove(list.getFirst());
        return "deleted";
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        Map<String, Hospital> map = new HashMap<>();
        for (Hospital h : DataBase.hospitals) {
            if (address.equals(h.getAddress())){
                map.put(address,h);
            }
        }
        return map;
    }
}
