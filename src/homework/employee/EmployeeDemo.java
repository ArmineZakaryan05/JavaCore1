package homework.employee;

import java.util.Scanner;

public class EmployeeDemo implements Commands{

    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeStorage employeeStorage = new EmployeeStorage();

    public static void main(String[] args) {

        boolean isRun = true;

        while (isRun) {
            Commands.printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_EMPLOYEE:
                    addEmployee();
                    break;
                case PRINT_ALL_EMPLOYEE:
                    employeeStorage.printAllEmployee();
                    break;
                case SEARCH_EMPLOYEE_BY_EMPLOYEE_ID:
                    searchEmployeeByEmployeeId();
                    break;
                case SEARCH_EMPLOYEE_BY_COMPANY_NAME:
                    searchEmployeeByCompanyName();
                    break;
                default:
                    System.err.println("Wrong command!");

            }
        }

    }

    private static void searchEmployeeByCompanyName() {
        employeeStorage.printAllEmployee();
        System.out.println("Please input company name.");
        String companyName = scanner.nextLine();
        employeeStorage.searchEmployeeByCompanyName(companyName);
    }


    private static void searchEmployeeByEmployeeId() {
        employeeStorage.printAllEmployee();
        System.out.println("Please input employee id.");
        String id = scanner.nextLine();
        employeeStorage.searchEmployeeByEmployeeId(id);
    }


    private static void addEmployee() {
        System.out.println("Please input employeeId.");
        String employeeId = scanner.nextLine();
        Employee employeeById = employeeStorage.getEmployeeById(employeeId);
        if (employeeById != null) {
            System.err.println("Employee with " + employeeId + " id already exists!");
            return;
        }
        System.out.println("Please input employee name.");
        String name = scanner.nextLine();
        System.out.println("Please input employee surname.");
        String surname = scanner.nextLine();
        System.out.println("Please input employee salary.");
        double salary = Double.parseDouble(scanner.nextLine());
        System.out.println("Please input employee company.");
        String company = scanner.nextLine();
        System.out.println("Please input employee position.");
        String position = scanner.nextLine();
        Employee employee = new Employee(employeeId, name, surname, salary, company, position);
        employeeStorage.add(employee);
        System.out.println("Employee added!");
    }
}
