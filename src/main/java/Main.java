
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        System.out.println("Please enter data of 5 employees");

        List<Employee> employeeList = getEmployeeList();

        printMenu();

        int menuOption;
        do {
            menuOption = new Scanner(System.in).nextInt();
            switch (menuOption) {
                case 1:
                    System.out.println("Sum of all employees salary is: " + getAllEmployeesSalary(employeeList));
                    printMenu();
                    break;
                case 2:
                    System.out.println("Data of employees:");
                    printAllEmployeeData(employeeList);
                    printMenu();
                    break;
                case 3:
                    employeeList.add(getEmployeeFromUser(0));
                    printMenu();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("You can enter only integers in range 1-4");
                    printMenu();
            }

        } while (menuOption != 4);

    }

    private static void printMenu() {
        System.out.println();
        System.out.println("Menu: ");
        System.out.println("1 – Print sum of all employees salary");
        System.out.println("2 – Display all employees data");
        System.out.println("3 – Add new employee");
        System.out.println("4 – End program");
    }

    private static List<Employee> getEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            employeeList.add(getEmployeeFromUser(i));
        }
        return employeeList;
    }

    private static Employee getEmployeeFromUser(int i) {

        System.out.println("Enter first name of " + (i + 1) + " employee:");
        String firstName = new Scanner(System.in).nextLine();

        System.out.println("Enter last name of " + (i + 1) + " employee:");
        String lastName = new Scanner(System.in).nextLine();

        System.out.println("Enter salary name of " + (i + 1) + " employee:");
        int salary = 0;
        do {
            try {
                salary = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.println("You entered string, please enter integer value");
                getEmployeeFromUser(i);
            }
        } while (salary == 0);

        return new Employee(firstName, lastName, salary);
    }

    private static int getAllEmployeesSalary(List<Employee> employeeList) {
        int salarySum = 0;
        for (Employee e : employeeList) {
            salarySum += e.getSalary();
        }
        return salarySum;
    }

    private static void printAllEmployeeData(List<Employee> employeeList) {
        for (Employee e : employeeList) {
            System.out.println(e.getAllData());
        }
    }
}
