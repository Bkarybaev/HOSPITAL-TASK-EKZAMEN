package hospital.dao.impl;

import hospital.dao.GenericDao;
import hospital.dao.PatientDao;
import hospital.db.DataBase;
import hospital.models.Hospital;
import hospital.models.Patient;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PatientDaoImpl implements PatientDao, GenericDao<Patient> {
    @Override
    public String add(Long hospitalId, Patient patient) {
        for (Hospital h : DataBase.hospitals) {
            if (h.getId().equals(hospitalId)) {
                h.getPatients().add(patient);
            }
        }
        return "Successfully added patient";
    }

    @Override
    public void removeById(Long id) {
        List<Patient> list = DataBase.hospitals.stream()
                .flatMap(hospital -> hospital.getPatients().stream())
                .toList();
        List<Patient> list1 = list.stream()
                .filter(patient -> !patient.getId().equals(id))
                .toList();
        for (Hospital hospital : DataBase.hospitals) {
            hospital.getPatients().addAll(list1);
        }
    }

    @Override
    public String updateById(Long id, Patient patient) {
        for (Hospital h : DataBase.hospitals) {
            for (Patient p : h.getPatients()) {
                if (p.getId().equals(id)) {
                    p.setAge(patient.getAge());
                    p.setGender(patient.getGender());
                    p.setFirstName(patient.getFirstName());
                    p.setLastName(patient.getLastName());
                    return "Successfully update patient";
                }
            }
        }
        return "not fount!!!";
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        for (Hospital h : DataBase.hospitals) {
            if (h.getId().equals(id)) {
                h.getPatients().addAll(patients);
                return "Successfully added patients";
            }
        }
        return "not fount!!!";
    }

    @Override
    public Patient getPatientById(Long id) {
        for (Hospital h : DataBase.hospitals) {
            for (Patient p : h.getPatients()) {
                if (p.getId().equals(id)) {
                    return p;
                }
            }
        }
        return null;
    }

    @Override
    public Map<Integer, List<Patient>> getPatientByAge() {
        Set<Integer> age = new TreeSet<>();

        for (Hospital h : DataBase.hospitals) {
            for (Patient p : h.getPatients()) {
                age.add(p.getAge());
            }
        }
        Map<Integer, List<Patient>> map = new LinkedHashMap<>();
        for (Integer i : age) {
            List<Patient> patient = new ArrayList<>();
            for (Hospital h : DataBase.hospitals) {
                for (Patient p : h.getPatients()) {
                    if (p.getAge() == i) {
                        patient.add(p);
                    }
                }
            }
            map.put(i, patient);
        }
        return map;
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {

        List<Patient> patients = new ArrayList<>();
        if (ascOrDesc.equals("asc")) {
            patients = DataBase.hospitals.stream()
                    .flatMap(hospital -> hospital.getPatients().stream())
                    .sorted()
                    .toList();

        } else if (ascOrDesc.equals("desc")) {
            patients = DataBase.hospitals.stream()
                    .flatMap(hospital -> hospital.getPatients().stream())
                    .sorted(Collections.reverseOrder())
                    .toList();
        }
        return patients;



    }

}
