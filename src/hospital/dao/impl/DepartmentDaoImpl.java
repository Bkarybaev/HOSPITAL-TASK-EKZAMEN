package hospital.dao.impl;

import hospital.dao.DepartmentDao;
import hospital.dao.GenericDao;
import hospital.db.DataBase;
import hospital.models.Department;
import hospital.models.Hospital;

import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao, GenericDao<Department> {
    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        for (Hospital h : DataBase.hospitals) {
           if (h.getId().equals(id)){
               return h.getDepartments();
           }
        }
        return List.of();
    }

    @Override
    public Department findDepartmentByName(String name) {
        for (Hospital h : DataBase.hospitals) {
            for (Department department : h.getDepartments()) {
                if (department.getDepartmentName().equalsIgnoreCase(name)){
                    return department;
                }
            }
        }
        return null;
    }

    @Override
    public String add(Long hospitalId, Department department) {
        for (Hospital h : DataBase.hospitals) {
            if (h.getId().equals(hospitalId)){
                h.getDepartments().add(department);
                return "Successfully added department";
            }
        }
        return "not fount!!!";
    }

    @Override
    public void removeById(Long id) {
        for (Hospital h : DataBase.hospitals) {
            for (Department department : h.getDepartments()) {
                if (department.getId().equals(id)){
                    h.getDepartments().remove(department);
                    break;
                }
            }
        }
    }

    @Override
    public String updateById(Long id, Department department) {
        for (Hospital h : DataBase.hospitals) {
            for (Department dep : h.getDepartments()) {
                if (dep.getId().equals(id)){
                   dep.setDepartmentName(department.getDepartmentName());
                   return "Successfully update department";
                }
            }
        }
        return "not fount!!!";
    }
}
