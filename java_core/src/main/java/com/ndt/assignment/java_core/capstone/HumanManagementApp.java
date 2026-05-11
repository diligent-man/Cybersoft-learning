package com.ndt.assignment.java_core.capstone;

import java.util.*;
import java.util.stream.*;

import com.ndt.assignment.java_core.capstone.entity.*;
import com.ndt.utils.AnsiColor;
import com.ndt.assignment.java_core.capstone.utils.DataPool;


public final class HumanManagementApp {
    private final String[] requirements = new String[]{
        "Thoát chương trình",
        "Nhập thông tin công ty",
        "Phân bổ Nhân viên vào Trưởng phòng",
        "Thêm, xóa thông tin một nhân sự (có thể là Nhân viên, trưởng phòng hoặc giám đốc). Lưu ý khi xóa trưởng phòng, phải ngắt liên kết với các nhân viên đang tham chiếu tới",
        "Xuất ra thông tin toàn bộ người trong công ty",
        "Tính và xuất tổng lương cho toàn công ty",
        "Tìm Nhân viên thường có lương cao nhất",
        "Tìm Trưởng Phòng có số lượng nhân viên dưới quyền nhiều nhất",
        "Sắp xếp nhân viên toàn công ty theo thứ tự abc",
        "Sắp xếp nhân viên toàn công ty theo thứ tự lương giảm dần",
        "Tìm Giám Đốc có số lượng cổ phần nhiều nhất",
        "Tính và Xuất tổng THU NHẬP của từng Giám Đốc",
    };

    private final Scanner sc = new Scanner(System.in);

    private final DataPool dataPool = new DataPool();

    private final CongTy congTy = CongTy.getInstance();

    private final List<Human> humanLst = new ArrayList<>();


    public HumanManagementApp() {
        System.out.println("Initializing data pool...");

        IntStream.range(0, 10).forEach(
            _ -> {
                humanLst.add(dataPool.getNhanVien());
                humanLst.add(dataPool.getTruongPhong());
                humanLst.add(dataPool.getGiamDoc());
            }
        );

        humanLst.sort(Comparator.comparing(e -> e.getClass().getSimpleName()));
        humanLst.forEach(System.out::println);
    }


    /* -------------------------------------------------------------------------------------------------------------- */
    private String _makePrompt(String[] requirements) {
        int maxLineWidth = Arrays.stream(requirements)
            .mapToInt(String::length)
            .max().orElse(0);

        StringBuilder sb = new StringBuilder();

        int maxLineTracker = 0;
        for (int i = 0; i < requirements.length; i++) {
            int idxWidth = String.valueOf(requirements.length).length();
            String formattedOpt = String.format(AnsiColor.RED + "%-" + idxWidth + "d" + AnsiColor.RESET, i);
            String formattedRequirement = String.format(AnsiColor.CYAN + "%-" + maxLineWidth + "s" + AnsiColor.RESET, requirements[i]);  // %-167s

            String line = String.format("| %s | %s |\n", formattedOpt, formattedRequirement);
            maxLineTracker = Math.max(maxLineTracker, idxWidth + maxLineWidth + "|  |  |\n".length());

            sb.append(line);
        }
        String decorator = "-".repeat(maxLineTracker - 1);
        sb.append(decorator);
        return decorator + "\n" + sb;
    }


    private <T extends Human> List<T> _getHumanByType(Class<T> clazz) {
        return humanLst.parallelStream()
            .filter(clazz::isInstance)
            .map(clazz::cast)
            .collect(Collectors.toList());
    }


    private <T extends Human> T _findByMaSo(List<T> lst, String maSo) {
        return lst.stream()
            .filter(ele -> ele.getMaSo().equals(maSo))
            .findFirst().orElse(null);
    }


    /* -------------------------------------------------------------------------------------------------------------- */
    public void inputCompanyInfo() {
        System.out.print("Nhap ten cong ty:");
        congTy.setTenCongTy(sc.nextLine());

        System.out.print("Nhap ma so thue:");
        congTy.setMaSoThue(sc.nextLine());

        byte tryTimes = 3;
        System.out.printf("Nhap doanh thu thang (remaining: %d):", tryTimes);
        while (tryTimes-- > 0) {
            String inp = sc.nextLine();

            try {
                congTy.setDoanhThuThang(Double.parseDouble(inp));
                break;
            } catch (NumberFormatException e) {
                System.out.println(AnsiColor.YELLOW + "Invalid input. Please enter a valid double number." + AnsiColor.RESET);
            }

            if (tryTimes > 0)
                System.out.printf("Nhap doanh thu thang (remaining: %d):", tryTimes);
            else
                congTy.setDoanhThuThang(null);
        }
    }


    public void assignEmployeeToDeptManager() {
        System.out.print("Select employee (by maSo) to assign to a department manager: ");
        String employeeMaSo = sc.nextLine();
        NhanVien nv = _findByMaSo(_getHumanByType(NhanVien.class), employeeMaSo);

        if (nv == null) {
            System.out.println("Invalid ma so nhan vien. Return to main menu.");
            return;
        }

        System.out.print("Select truong phong (by maSo): ");
        String truongPhongMaSo = sc.nextLine();
        TruongPhong tp = _findByMaSo(_getHumanByType(TruongPhong.class), truongPhongMaSo);

        if (tp == null) {
            System.out.println("Invalid ma so truong phong. Return to main menu.");
            return;
        }

        nv.setTruongPhong(tp);
        tp.quanLy(nv);

        _getHumanByType(NhanVien.class).forEach(System.out::println);
        System.out.println();
        System.out.println();
        _getHumanByType(TruongPhong.class).forEach(System.out::println);
        System.out.println();
        System.out.println();
    }


    public void modifyHumanInfo() {
        String modifyPrompt = "1. Add a new human\n2. Remove an existing human";
        System.out.println("Enter operation to perform:\n" + modifyPrompt);
        String opt = sc.nextLine();

        switch (opt) {
            case "1" -> {
                String humanPrompt = "1. NhanVien\n2. TruongPhong\n3. GiamDoc";
                System.out.println("Enter human type to add:\n" + humanPrompt);
                String humanType = sc.nextLine();

                switch (humanType) {
                    case "1" -> humanLst.add(dataPool.getNhanVien());
                    case "2" -> humanLst.add(dataPool.getTruongPhong());
                    case "3" -> humanLst.add(dataPool.getGiamDoc());
                    default -> System.out.println("Invalid human type. Return to main menu.");
                }
            }

            case "2" -> {
                System.out.print("Enter maSo of the employee to modify: ");
                String maSo = sc.nextLine();

                Optional<Human> human = humanLst.parallelStream().filter(e -> e.getMaSo().equals(maSo)).findFirst();

                if (human.isEmpty()) {
                    System.out.println("Invalid ma so. Return to main menu.");
                } else {
                    human.get().remove();
                    humanLst.remove(human.get());
                    System.out.println("Human information has been removed.");
                    System.out.println();
                    System.out.println();
                }
            }

            default -> System.out.println("Invalid option. Return to main menu.");
        }
    }


    public void getAllHumanInfo() {
        System.out.printf("%s%40sCompany's employees information%s\n", AnsiColor.PURPLE, " ", AnsiColor.RESET);
        humanLst.forEach(System.out::println);
        System.out.println("\n");
    }


    public void computeHumanSalary(Stream<? extends Human> stream, String prompt) {
        System.out.printf(prompt);
        stream.forEach(ele -> System.out.printf("maSo: %s, luong: %.4f\n", ele.getMaSo(), ele.tinhLuongThang()));
        System.out.println("\n");
    }


    public <T extends Human> void findHumanBySalary(List<T> humanLst, Comparator<T> comparator, String prompt) {
        // Tìm Nhân viên thường có lương cao nhất
        Human nv = humanLst.stream().max(comparator).orElse(null);
        System.out.println(prompt + nv);
        System.out.println();
    }


    public void findDeptManagerHavingHighestSubordinates() {
        TruongPhong tp = _getHumanByType(TruongPhong.class).stream().max(Comparator.comparing(TruongPhong::getSoLuongNhanVienQuanLy)).orElse(null);

        System.out.println("Department manager having highest subordinates:" + tp);
        System.out.println();
    }


    public void sortEmployee(Comparator<Human> comparator) {
        humanLst.stream().sorted(comparator).forEach(System.out::println);
    }


    public void run() {
        String prompt = _makePrompt(requirements);
        System.out.println(prompt);

        Scanner sc = new Scanner(System.in);
        String opt;

        while (true) {
            System.out.print("Enter your option: ");
            opt = sc.nextLine();

            switch (opt) {
                case "0" -> {
                    System.out.println(AnsiColor.GREEN + "Exit programme successfully !" + AnsiColor.RESET);
                    System.exit(0);
                }
                case "1" -> inputCompanyInfo();
                case "2" -> assignEmployeeToDeptManager();
                case "3" -> modifyHumanInfo();
                case "4" -> getAllHumanInfo();
                case "5" -> computeHumanSalary(
                    humanLst.stream(),
                    String.format("%s%40sCompany's salary information%s\n", AnsiColor.BLUE, " ", AnsiColor.RESET)
                );
                case "6" ->
                    findHumanBySalary(_getHumanByType(NhanVien.class), Comparator.comparing(Human::tinhLuongThang), "Nhan vien having highest salary: ");
                case "7" -> findDeptManagerHavingHighestSubordinates();
                case "8" -> sortEmployee(Comparator.comparing(Human::getHoTen));
                case "9" -> sortEmployee(Comparator.comparing(Human::tinhLuongThang).reversed());
                case "10" ->
                    findHumanBySalary(_getHumanByType(GiamDoc.class), Comparator.comparing(GiamDoc::getCoPhan), "Giam doc having highest salary: ");
                case "11" -> computeHumanSalary(
                    _getHumanByType(GiamDoc.class).stream(),
                    String.format("%s%40sDirector's salary information%s\n", AnsiColor.BLUE, " ", AnsiColor.RESET)
                );
                default -> System.out.println(AnsiColor.YELLOW + "Invalid option !\n" + AnsiColor.RESET);
            }

            System.out.println(prompt);
        }
    }
}
