import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        NhanVien[] danhSach = new NhanVien[2];
        danhSach[0] = new NhanVienParttime("PT01", "Tuan", 20, "091-243-3211", "Tuan@gmail.com");
        danhSach[1] = new NhanVienFulltime("FT01", "Toan", 20, "091-123-4569", "Toan@gmail.com", 10000000);
        Scanner input = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("Welcome");
            System.out.println("1.Add new employee");
            System.out.println("2.Edit employee");
            System.out.println("3.Calculate an employee salary");
            System.out.println("4.Delete an employee");
            System.out.println("5.Show all employee");
            System.out.println("6.Show employee with below average salary");
            System.out.println("0.Exit");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1 -> {
                    System.out.println("1.Add new Full-time employee");
                    System.out.println("2.Add new Part-time employee");
                    int select = input.nextInt();
                    switch (select) {
                        case 1 -> danhSach = Management.addFulltime(danhSach);
                        case 2 -> danhSach = Management.addParttime(danhSach);
                    }
                }
                case 2 -> {
                    System.out.println("Input Employee ID");
                    String id = input.nextLine();
                    NhanVien target = null;
                    for (NhanVien n : danhSach) {
                        if (id.equals(n.getId())) {
                            target = n;
                        }
                    }
                    int select = Integer.parseInt(input.nextLine());
                    switch (select) {
                        case 1 -> {
                            System.out.println("Input new ID");
                            String newID = input.nextLine();
                            assert target != null;
                            target.setId(newID);
                        }
                        case 2 -> {
                            System.out.println("Input new Name");
                            String newName = input.nextLine();
                            assert target != null;
                            target.setName(newName);
                        }
                        case 3 -> {
                            System.out.println("Input new age");
                            int newAge = input.nextInt();
                            assert target != null;
                            target.setAge(newAge);
                        }
                        case 4 -> {
                            System.out.println("Input new phone number");
                            String newPhone = input.nextLine();
                            assert target != null;
                            target.setPhoneNumber(newPhone);
                        }
                        case 5 -> {
                            System.out.println("Input new Email");
                            String newEmail = input.nextLine();
                            assert target != null;
                            target.setEmail(newEmail);
                        }
                        case 6 -> {
                            if (target instanceof NhanVienFulltime) {
                                System.out.println("Input new salary");
                                int newSalary = input.nextInt();
                                ((NhanVienFulltime) target).setSalary(newSalary);
                            } else {
                                System.out.println("Cannot set salary for part-time");
                            }
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Input employee ID");
                    String id = input.nextLine();
                    NhanVien target = null;
                    for (NhanVien n : danhSach) {
                        if (id.equals(n.getId())) {
                            target = n;
                        }
                    }
                    if (target instanceof NhanVienFulltime) {
                        System.out.println("Employee name: " + target.getName() + " Salary: " + ((NhanVienFulltime) target).getFullSalary());
                    } else if (target instanceof NhanVienParttime) {
                        System.out.println("Employee name: " + target.getName() + " Salary: " + ((NhanVienParttime) target).getSalary());
                    }
                }
                case 4 -> danhSach = Management.delete(danhSach);
                case 5 -> Management.showAll(danhSach);
                case 6 -> Management.getBelowAverage(danhSach);
                case 0 -> System.exit(0);
            }
        }
    }
}
