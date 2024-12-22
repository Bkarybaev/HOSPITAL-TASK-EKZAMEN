package hospital.dao.impl;

import hospital.dao.DoctorDao;
import hospital.dao.GenericDao;
import hospital.db.DataBase;
import hospital.models.Department;
import hospital.models.Doctor;
import hospital.models.Hospital;

import java.util.ArrayList;
import java.util.List;

public class DoctorDaoImpl implements DoctorDao, GenericDao<Doctor> {
    @Override
    public Doctor findDoctorById(Long id) {
        for (Hospital h : DataBase.hospitals) {
            for (Doctor d : h.getDoctors()) {
                if (d.getId().equals(id)){
                    return d;
                }
            }
        }
        return null;
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        List<Doctor> doctors = new ArrayList<>();
        for (Hospital h : DataBase.hospitals) {
            for (Doctor d : h.getDoctors()) {
                for (Long l : doctorsId) {
                    if (d.getId().equals(l)){
                        doctors.add(d);
                    }
                }
            }
        }
        for (Hospital h : DataBase.hospitals) {
            for (Department d : h.getDepartments()) {
                if (d.getId().equals(departmentId)){
                    d.setDoctors(doctors);
                    return "Successfully added doctors to department!!";
                }
            }
        }
        return "not fount";
    }
    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        for (Hospital h : DataBase.hospitals) {
            if (h.getId().equals(id)){
                return h.getDoctors();
            }
        }
        return List.of();
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        for (Hospital h : DataBase.hospitals) {
            for (Department d : h.getDepartments()) {
                if (d.getId().equals(id)){
                    return d.getDoctors();
                }
            }
        }
        return List.of();
    }

    @Override
    public String add(Long hospitalId, Doctor doctor) {
        for (Hospital h : DataBase.hospitals) {
            if (h.getId().equals(hospitalId)){
                h.getDoctors().add(doctor);
                return "Successfully added doctor";
            }
        }
        return "not fount!!!";
    }

    @Override
    public void removeById(Long id) {
        for (Hospital h : DataBase.hospitals) {
            for (Doctor doctor : h.getDoctors()) {
                if (doctor.getId().equals(id)){
                    h.getDoctors().remove(doctor);
                    System.out.println("deleted doctor by " + id);
                }
            }
        }

    }

    @Override
    public String updateById(Long id, Doctor doctor) {
        for (Hospital h : DataBase.hospitals) {
            for (Doctor d : h.getDoctors()) {
                if (d.getId().equals(id)){
                    d.setGender(doctor.getGender());
                    d.setFirstName(doctor.getFirstName());
                    d.setLastName(doctor.getLastName());
                    d.setExperienceYear(doctor.getExperienceYear());
                    return "Successfully update doctor";
                }
            }
        }
        return "not fount!!!";
    }
}
