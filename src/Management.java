import java.util.Scanner;

public class Management {
    public static void showAll(NhanVien[] arr) {
        for (NhanVien n : arr) {
            System.out.println(n);
        }
    }
    public static NhanVien[] addParttime(NhanVien[] arr){
        Scanner input = new Scanner(System.in);
        System.out.println("Adding part-time employee");
        System.out.println("Input ID");
        String id = input.nextLine();
        System.out.println("Input Name");
        String name = input.nextLine();
        System.out.println("Input email");
        String email = input.nextLine();
        System.out.println("Input age");
        int age = Integer.parseInt(input.nextLine());
        System.out.println("Input phoneNumber");
        String phoneNumber = input.nextLine();
        NhanVien nv = new NhanVienParttime(id, name, age, phoneNumber, email);
        NhanVien[] newArr = new NhanVien[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        newArr[newArr.length - 1] = nv;
        return newArr;
    }
    public static NhanVien[] addFulltime(NhanVien[] arr){
        Scanner input = new Scanner(System.in);
        System.out.println("Adding full-time employee");
        System.out.println("Input ID");
        String id = input.nextLine();
        System.out.println("Input Name");
        String name = input.nextLine();
        System.out.println("Input email");
        String email = input.nextLine();
        System.out.println("Input age");
        int age = Integer.parseInt(input.nextLine());
        System.out.println("Input phoneNumber");
        String phoneNumber = input.nextLine();
        System.out.println("Input initial salary");
        int salary = Integer.parseInt(input.nextLine());
        NhanVien nv = new NhanVienFulltime(id, name, age, phoneNumber, email, salary);
        NhanVien[] newArr = new NhanVien[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        newArr[newArr.length - 1] = nv;
        return newArr;
    }
    public static void getBelowAverage(NhanVien[] arr){
        int average = 0;
        int count =0;
        for(NhanVien n : arr){
            if (n instanceof NhanVienFulltime){
                average += ((NhanVienFulltime) n).getSalary();
                count ++;
            }
        }
        average /= count;
        System.out.println("Company's full-time employee average salary is:" + average);
        for(NhanVien n : arr){
            if (n instanceof NhanVienFulltime){
                if(((NhanVienFulltime) n).getSalary() < average){
                    System.out.println(n);
                }
            }
        }
    }
    public static NhanVien[] delete(NhanVien[] arr){
        Scanner input = new Scanner(System.in);
        System.out.println("Input employee ID to delete");
        NhanVien[] newArr = new NhanVien[arr.length - 1];
        String id = input.nextLine();
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (id.equals(arr[i].getId())) {
                start = i;
            }
        }
        for (int i = start; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = null;
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
}
