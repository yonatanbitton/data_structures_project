public class Student {
    long id;
    String name;
    String department;

    public Student(long id, String name, String department){
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "id = " + id + "; name = " + name + "; depatment = " + department;
    }
}
