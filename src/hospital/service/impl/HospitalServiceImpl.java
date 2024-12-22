package hospital.service.impl;

import hospital.dao.impl.HospitalDaoImpl;
import hospital.models.Hospital;
import hospital.models.Patient;
import hospital.service.HospitalService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HospitalServiceImpl implements HospitalService {

    private final HospitalDaoImpl hospitalDao = new HospitalDaoImpl();

    @Override
    public String addHospital(Hospital hospital) {
        try {
            hospitalDao.addHospital(hospital);
            return "Successfully added hospital";
        } catch (Exception e) {
            return "Failed to add hospital: " + e.getMessage();
        }
    }

    @Override
    public Hospital findHospitalById(Long id) {
        try {
            return hospitalDao.findHospitalById(id);
        } catch (Exception e) {
            System.out.println("Failed to find hospital by ID: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Hospital> getAllHospital() {
        try {
            return hospitalDao.getAllHospital();
        } catch (Exception e) {
            System.out.println("Failed to get all hospitals: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        try {
            return hospitalDao.getAllPatientFromHospital(id);
        } catch (Exception e) {
            System.out.println("Failed to get all patients from hospital: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public String deleteHospitalById(Long id) {
        try {
            hospitalDao.deleteHospitalById(id);
            return "Successfully deleted hospital by ID: " + id;
        } catch (Exception e) {
            return "Failed to delete hospital by ID: " + e.getMessage();
        }
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        try {
            return hospitalDao.getAllHospitalByAddress(address);
        } catch (Exception e) {
            System.out.println("Failed to get hospitals by address: " + e.getMessage());
            return new HashMap<>();
        }
    }

}
