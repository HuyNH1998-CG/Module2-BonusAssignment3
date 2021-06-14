import java.util.Scanner;

public class NhanVienFulltime extends NhanVien {
    private int bonus;
    private int penalty;
    private int salary;

    public NhanVienFulltime() {
    }

    public NhanVienFulltime(String id, String name, int age, String phoneNumber, String email, int salary) {
        super(id, name, age, phoneNumber, email);
        this.salary = salary;
    }

    public NhanVienFulltime(String id, String name, int age, String phoneNumber, String email, int bonus, int penalty, int salary) {
        super(id, name, age, phoneNumber, email);
        this.bonus = bonus;
        this.penalty = penalty;
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getFullSalary(){
        Scanner input = new Scanner(System.in);
        System.out.println("Input bonus");
        int newBonus = input.nextInt();
        this.setBonus(newBonus);
        System.out.println("Input penalty");
        int newPenalty = input.nextInt();
        this.setPenalty(newPenalty);
        return this.getSalary() + (this.getBonus() - this.getPenalty());
    }
    @Override
    public String toString() {
        return "NhanVienFulltime{ " + super.toString() +
                " bonus=" + bonus +
                ", penalty=" + penalty +
                ", salary=" + salary +
                '}';
    }
}
