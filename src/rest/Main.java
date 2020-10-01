package rest;

public class Main {

    public static void main(String[] args) {
        Employee[] employees = getEmployeeArray();
        for (Employee employee : employees) {
            if (employee.getAge() >= 40) System.out.println(employee.printString());
        }

    }

    private static Employee[] getEmployeeArray() {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Ivan Ivanov", "Manager", "ivanov@ivan.ru",
                "5551111", 30000, 30);
        employees[1] = new Employee("Petr Petrov", "Boss", "petrov@petr.ru",
                "5552222", 40000, 40);
        employees[2] = new Employee("Sidr Sidorov", "Drinking", "sidoriv@sidr.ru",
                "5551111", 50000, 50);
        employees[3] = new Employee("Lena Golovach", "Top manager", "lena@golovach.ru",
                "5551111", 60000, 60);
        employees[4] = new Employee("Djaina Praudmur", "Ice witch", "praudmur@djaina.ru",
                "5551111", 70000, 18);
        return employees;
    }
}
