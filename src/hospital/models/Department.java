package hospital.models;

import java.util.ArrayList;
import java.util.List;

public class Department {
   private Long id;
   private String departmentName;
   private List<Doctor> doctors = new ArrayList<>();

    static Long generateId = 1L;

    public Department() {
        this.id = generateId++;
    }

    public Department(String departmentName) {
        this.id = generateId++;
        this.departmentName = departmentName;
    }

    public Department(String departmentName, List<Doctor> doctors) {
        this.id = generateId++;
        this.doctors = doctors;
        this.departmentName = departmentName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", doctors=" + doctors +
                '}'+"\n";
    }
}
