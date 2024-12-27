package hospital.dao.impl;

import hospital.dao.DepartmentDao;
import hospital.dao.GenericDao;
import hospital.db.DataBase;
import hospital.models.Department;
import hospital.models.Hospital;

import java.util.List;
import java.util.Optional;

public class DepartmentDaoImpl implements DepartmentDao, GenericDao<Department> {
    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        return DataBase.hospitals.stream()
                .filter(hospital -> hospital.getId().equals(id))
                .findFirst()
                .map(Hospital::getDepartments)
                .orElse(List.of());
    }

    @Override
    public Department findDepartmentByName(String name) {
        return DataBase.hospitals.stream()
                .flatMap(hospital -> hospital.getDepartments().stream())
                .filter(department -> department.getDepartmentName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }


    @Override
    public String add(Long hospitalId, Department department) {
        DataBase.hospitals.stream()
                .filter(hospital -> hospital.getId().equals(hospitalId))
                .findFirst()
                .ifPresent(hospital -> hospital.getDepartments().add(department));
        return "Successful";
    }

    @Override
    public void removeById(Long id) {
        DataBase.hospitals.removeIf(
                i -> i.getDepartments().stream()
                        .filter(o-> o.getId()
                        .equals(id)).isParallel());
    }

    @Override
    public String updateById(Long id, Department department) {
        Optional<Department> updatedDepartment = DataBase.hospitals.stream()
                .flatMap(hospital -> hospital.getDepartments().stream())
                .filter(dep -> dep.getId().equals(id))
                .findFirst();

        updatedDepartment.ifPresent(dep -> dep.setDepartmentName(department.getDepartmentName()));
        return "Successfully update!!";
    }
}
