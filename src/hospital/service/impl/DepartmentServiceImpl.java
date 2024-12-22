package hospital.service.impl;

import hospital.dao.impl.DepartmentDaoImpl;
import hospital.dao.impl.HospitalDaoImpl;
import hospital.models.Department;
import hospital.models.Hospital;
import hospital.service.DepartmentService;
import hospital.service.GenericService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService, GenericService<Department> {

    private final DepartmentDaoImpl departmentDao = new DepartmentDaoImpl();
    private final HospitalDaoImpl hospitalDao = new HospitalDaoImpl();

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        for (Hospital h : hospitalDao.getAllHospital()) {
            for (Department department : h.getDepartments()) {
                if (department.getId().equals(id)) return departmentDao.getAllDepartmentByHospital(id);
            }
        }
        try {
            throw new RuntimeException("not fount!!");
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Department findDepartmentByName(String name) {
        try {
            if (name.isEmpty()){
                throw new RuntimeException("name null!!!");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return departmentDao.findDepartmentByName(name);
    }

    @Override
    public String add(Long hospitalId, Department department) {
        try {
            return departmentDao.add(hospitalId, department);
        } catch (Exception e) {
            return "Failed to add department: " + e.getMessage();
        }
    }

    @Override
    public void removeById(Long id) {
        try {
            departmentDao.removeById(id);
            System.out.println("Department removed successfully.");
        } catch (Exception e) {
            System.out.println("Failed to remove department: " + e.getMessage());
        }
    }

    @Override
    public String updateById(Long id, Department department) {
        try {
            return departmentDao.updateById(id, department);
        } catch (Exception e) {
            return "Failed to update department: " + e.getMessage();
        }
    }

}
