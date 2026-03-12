import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;


        do {
            System.out.println(
                    """
                            ========= PRODUCT MANAGEMENT SYSTEM =========
                            1. Thêm sản phẩm mới
                            2. Hiển thị danh sách sản phẩm
                            3. Cập nhật số lượng theo ID
                            4. Xóa sản phẩm đã hết hàng
                            5. Thoát chương trình
                            =============================================
                            """
            );
            System.out.println("Mời bạn nhập lựa chọn : ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    displayAll();
                    break;
                case 3:
                    updateProduct(scanner);
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    System.out.println("Thoát trương trình thành công");
                    break;
                default:
                    System.out.println("Lựa chọn sai vui lòng nhập lại");
            }
        }while (choice != 5);

    }
    public static void addProduct( Scanner sc){
        System.out.println("Nhập tên sản phẩm : ");
        String name = sc.nextLine();
        if (name.isEmpty()){
            System.out.println("Tên sp rỗng");
            return;
        }
        System.out.println("Nhập giá sản phẩm : ");
        double price = Double.parseDouble(sc.nextLine());
        if (price < 0){
            System.out.println("Giá sp nhỏ hơn 0");
            return;
        }
        System.out.println("Nhập số lượng tồn kho : ");
        int quantity = Integer.parseInt(sc.nextLine());
        if (quantity < 0){
            System.out.println(" số lượng tồn kho < 0");
            return;
        }
        System.out.println("Nhập tên danh mục : ");
        String category = sc.nextLine();
        if (category.isEmpty()){
            System.out.println("Tên danh mục rỗng");
            return;
        }

        Product newProduct = new Product(name,price,quantity,category);

        if (newProduct == null){
            throw new InvalidProductException("Sp được tạo ra đang null");
        }

        products.add(newProduct);
        System.out.println("thêm sản phẩm thành công");
    }


    public static void deleteProduct(){
        if (products.isEmpty()){
            System.out.println("Danh sách sản phẩm rỗng");
            return;
        }

       products = products.stream().filter(element -> element.getQuantity() > 0).toList();
        System.out.println("đã xóa các sp có số lượng  = 0");
    }

    public void updateProduct(Scanner sc){

        System.out.println("Nhập tên danh mục : ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập số lượng tồn kho : ");
        int quantity = Integer.parseInt(sc.nextLine());


        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id){
                products.get(i).setQuantity(quantity);
                return;
            }
        }

        throw new InvalidProductException("Không tìm thấy sp cần cập nhật");
    }


    public static void displayAll(){

        if (products.isEmpty()){
            System.out.println("Danh sách sản phẩm rỗng");
            return;
        }
        System.out.println("Danh sách sản phẩm : ");
        products.stream().forEach(System.out::println);
    }
}
























