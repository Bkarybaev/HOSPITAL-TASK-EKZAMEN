package hospital;

import hospital.enums.Gender;
import hospital.models.Department;
import hospital.models.Doctor;
import hospital.models.Hospital;
import hospital.models.Patient;
import hospital.service.impl.DepartmentServiceImpl;
import hospital.service.impl.DoctorServiceImpl;
import hospital.service.impl.HospitalServiceImpl;
import hospital.service.impl.PatientServiceImpl;

import java.util.*;

public class Main {

    static DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
    static HospitalServiceImpl hospitalService = new HospitalServiceImpl();
    static DoctorServiceImpl doctorService = new DoctorServiceImpl();
    static PatientServiceImpl patientService = new PatientServiceImpl();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Patient> patients = new ArrayList<>(List.of(
                new Patient( "Динара ", " Назарова", 54, Gender.FEMALE),
                new Patient( "Белек ", " Муратов", 54, Gender.MALE),
                new Patient( "Арген ", " Эрмеков", 46, Gender.MALE),
                new Patient( "Сыймык ", " Жоломанов", 36, Gender.MALE)));

        while (true) {
            System.out.println("""
                    Commands:
                    1 -> Hospital add
                    2 -> Find Hospital By ID
                    3 -> Get All Hospital
                    4 -> Delete Hospital By ID
                    5 -> Get All Patients By Hospital
                    6 -> Add Doctor
                    7 -> Find Doctor By ID
                    8 -> Get All Doctors By Hospital ID
                    9 -> Add Department
                    10 -> Get All Department By Hospital
                    11 -> Assign Doctor To Department
                    12 -> Update Doctor
                    13 -> Update Department
                    14 -> Remove Doctor
                    15 -> Remove Department
                    16 -> Sort Patients by age
                    17 -> Get All Hospital By Address
                    18 -> Add Patients By Hospital ID
                    19 -> Get patient by id
                    20 -> Get patient by age
                    21 -> get all doctors by department id
                    22 -> find department by name
                    23 -> back
                    """);

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println(hospitalService.addHospital(new Hospital( "Городская Болница", "#4")));
                    System.out.println(hospitalService.addHospital(new Hospital( "Городская Болница", "#6")));
                    System.out.println(hospitalService.addHospital(new Hospital( "Мамакеев", "Гагарина")));
                }
                case 2 -> {
                    System.out.println(hospitalService.findHospitalById(1L));
                }
                case 3 -> {
                    hospitalService.getAllHospital().forEach(System.out::println);
                }
                case 4 -> {
                    System.out.println(hospitalService.deleteHospitalById(2L));
                }
                case 5 -> {
                    System.out.println(hospitalService.getAllPatientFromHospital(1L));
                }
                case 6 -> {
                    System.out.println(doctorService.add(1L, new Doctor( "Айбек", "Маткеримов", Gender.MALE, 7)));
                    System.out.println(doctorService.add(1L, new Doctor( "Айзада", "Керимова", Gender.FEMALE, 8)));
                    System.out.println(doctorService.add(1L, new Doctor( "Бакыт", "Исмаилов", Gender.MALE, 10)));
                    System.out.println(doctorService.add(1L, new Doctor( "Жаркын", "Бекмуратов", Gender.MALE, 12)));
                    System.out.println(doctorService.add(1L, new Doctor( "Жаркын", "Бекмуратов", Gender.MALE, 22)));
                    System.out.println(doctorService.add(1L, new Doctor( "Асел", "Токтосунова", Gender.FEMALE, 9)));
                    System.out.println(doctorService.add(2L, new Doctor( "Чынгыз", "Абылов", Gender.MALE, 11)));
                    System.out.println(doctorService.add(2L, new Doctor( "Нурия", "Сатыбалдиева", Gender.FEMALE, 13)));
                    System.out.println(doctorService.add(2L, new Doctor( "Эркин", "Усубалиев", Gender.MALE, 6)));
                    System.out.println(doctorService.add(2L, new Doctor( "Жанара", "Асанова", Gender.FEMALE, 14)));
                    System.out.println(doctorService.add(2L, new Doctor( "Улан", "Байышев", Gender.MALE, 8)));
                    System.out.println(doctorService.add(3L, new Doctor( "Гулназ", "Абдиева", Gender.FEMALE, 7)));
                    System.out.println(doctorService.add(3L, new Doctor( "Эльдар", "Мусабеков", Gender.MALE, 9)));
                    System.out.println(doctorService.add(3L, new Doctor( "Дамира", "Токтоналиева", Gender.FEMALE, 15)));
                    System.out.println(doctorService.add(3L, new Doctor( "Кубан", "Курманалиев", Gender.MALE, 10)));
                    System.out.println(doctorService.add(3L, new Doctor( "Мээрим", "Шаршеева", Gender.FEMALE, 12)));
                }
                case 7 -> {
                    System.out.println(doctorService.findDoctorById(1L));
                }
                case 8 -> {
                    System.out.println(doctorService.getAllDoctorsByHospitalId(1L));
                }
                case 9 -> {
                    System.out.println(departmentService.add(1L, new Department( "Кардиология")));
                    System.out.println(departmentService.add(1L, new Department( "Неврология")));
                    System.out.println(departmentService.add(2L, new Department( "Онкология")));
                    System.out.println(departmentService.add(3L, new Department( "Педиатрия")));
                    System.out.println(departmentService.add(2L, new Department( "Хирургия")));
                }
                case 10 -> {
                    System.out.println(departmentService.getAllDepartmentByHospital(1L));
                }
                case 11 -> {
                    System.out.println(doctorService.assignDoctorToDepartment(1L,List.of(11L,12L)));
                }
                case 12 -> {
                    System.out.println(doctorService.updateById(1L, new Doctor( "Азат", "Эшенов", Gender.MALE, 11)));
                }
                case 13 -> {
                    System.out.println(departmentService.updateById(2L, new Department( "Диогностический отделение", List.of(new Doctor( "Элнура ", " Атаканова", Gender.FEMALE, 9), new Doctor( "Таалай ", "Ынтымаков", Gender.FEMALE, 7)))));
                }
                case 14 -> {
                    doctorService.removeById(1L);
                }
                case 15 -> {
                    departmentService.removeById(2L);
                }
                case 16 -> {
                    System.out.println(patientService.sortPatientsByAge("asc"));
                }
                case 17 -> {
                    System.out.println(hospitalService.getAllHospitalByAddress("Гагарина"));
                }
                case 18 -> {
                    System.out.println(patientService.addPatientsToHospital(1L, patients));
                }
                case 19 ->{
                    System.out.println(patientService.getPatientById(1L));
                }
                case 20 -> {
                    Map<Integer, List<Patient>> patientByAge = patientService.getPatientByAge();
                    for (Map.Entry<Integer, List<Patient>> entry : patientByAge.entrySet()) {
                        System.out.println("Age: " + entry.getKey() + " \n->" + entry.getValue());
                    }
                }
                case 21 -> {
                    System.out.println(doctorService.getAllDoctorsByDepartmentId(1L));
                }
                case 22 -> System.out.println(departmentService.findDepartmentByName("Кардиология"));
                case 23 -> {
                    System.out.println("Logout...");
                    return;
                }

                default -> System.err.println("Invalid command");
            }
        }
        }

}