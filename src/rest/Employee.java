package rest;

public class Employee {
    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee(String name, String position, String email, String phoneNumber, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    /**
     * по заданию конечно надо написать метод, но хотя мы и не знаем что это такое, переопределить toString наверно лучше
     */
    public String printString(){
        return "Сотрудник{\n" +
                "Имя Фамилия : " + name + '\n' +
                "Должность   : " + position + '\n' +
                "Эл. адрес   : " + email + '\n' +
                "Телефон     : " + phoneNumber + '\n' +
                "Зарплата    : " + salary + '\n' +
                "Возраст     : " + age + '\n' +
                '}';
    }

    @Override
    public String toString() {
        return "Сотрудник{\n" +
                "Имя Фамилия : " + name + '\n' +
                "Должность   : " + position + '\n' +
                "Эл. адрес   : " + email + '\n' +
                "Телефон     : " + phoneNumber + '\n' +
                "Зарплата    : " + salary + '\n' +
                "Возраст     : " + age + '\n' +
                '}';
    }
}
