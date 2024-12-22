package hospital.dao.impl;

import hospital.dao.HospitalDao;
import hospital.db.DataBase;
import hospital.models.Hospital;
import hospital.models.Patient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HospitalDaoImpl implements HospitalDao {
    @Override
    public String addHospital(Hospital hospital) {
        DataBase.hospitals.add(hospital);
        return "Successfully added Hospital";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        for (Hospital h : DataBase.hospitals) {
            if (h.getId().equals(id)){
                return h;
            }
        }
        return null;
    }

    @Override
    public List<Hospital> getAllHospital() {
        return DataBase.hospitals;
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        Hospital hospitalById = findHospitalById(id);
        return hospitalById.getPatients();
    }

    @Override
    public String deleteHospitalById(Long id) {
        Hospital hospitalById = findHospitalById(id);
        DataBase.hospitals.remove(hospitalById);
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
