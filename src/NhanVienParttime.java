import java.util.Scanner;

public class NhanVienParttime extends NhanVien {
    private int workTime;

    public NhanVienParttime() {
    }

    public NhanVienParttime(String id, String name, int age, String phoneNumber, String email) {
        super(id, name, age, phoneNumber, email);
    }

    public NhanVienParttime(String id, String name, int age, String phoneNumber, String email, int workTime) {
        super(id, name, age, phoneNumber, email);
        this.workTime = workTime;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    public int getSalary(){
        Scanner input = new Scanner(System.in);
        System.out.println("How many work hour?");
        int newWorkTime = input.nextInt();
        this.setWorkTime(newWorkTime);
        return this.getWorkTime()*100000;
    }
    @Override
    public String toString() {
        return "NhanVienParttime{ " + super.toString() +
                " workTime=" + workTime +
                '}';
    }
}
