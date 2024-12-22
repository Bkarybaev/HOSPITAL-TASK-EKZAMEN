package hospital.service.impl;

import hospital.dao.impl.PatientDaoImpl;
import hospital.models.Patient;
import hospital.service.GenericService;
import hospital.service.PatientService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientServiceImpl implements PatientService, GenericService<Patient> {

    PatientDaoImpl patientDao = new PatientDaoImpl();

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        try {
            return patientDao.addPatientsToHospital(id, patients);
        } catch (Exception e) {
            return "Failed to add patients to hospital: " + e.getMessage();
        }
    }

    @Override
    public Patient getPatientById(Long id) {
        try {
            return patientDao.getPatientById(id);
        } catch (Exception e) {
            System.out.println("Failed to get patient by ID: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Map<Integer, List<Patient>> getPatientByAge() {
        try {
            return patientDao.getPatientByAge();
        } catch (Exception e) {
            System.out.println("Failed to get patients by age: " + e.getMessage());
            return new HashMap<>();
        }
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        try {
            return patientDao.sortPatientsByAge(ascOrDesc);
        } catch (Exception e) {
            System.out.println("Failed to sort patients by age: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public String add(Long hospitalId, Patient patient) {
        try {
            return patientDao.add(hospitalId, patient);
        } catch (Exception e) {
            return "Failed to add patient: " + e.getMessage();
        }
    }

    @Override
    public void removeById(Long id) {
        try {
            patientDao.removeById(id);
            System.out.println("Successfully removed patient by ID: " + id);
        } catch (Exception e) {
            System.out.println("Failed to remove patient by ID: " + e.getMessage());
        }
    }

    @Override
    public String updateById(Long id, Patient patient) {
        try {
            return patientDao.updateById(id, patient);
        } catch (Exception e) {
            return "Failed to update patient by ID: " + e.getMessage();
        }
    }

}
