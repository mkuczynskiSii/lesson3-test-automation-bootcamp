import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Employee {

    private String firstName;
    private String lastName;
    private int salary;

    public String getAllData(){
        return "Salary for " + firstName + " " + lastName + " is " + salary;
    }
}
