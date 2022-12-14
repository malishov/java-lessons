package UI;

import Repositories.Repository;

import java.util.Scanner;

public class UI {
    private static Repository repository;
    private static Scanner scanner = new Scanner(System.in);

    public static void run(Repository repo) {
        repository = repo;
        renderStageOption();
    }

    public static void renderStageOption() {

        int input = 0;
        boolean whileRunner = true;

        while (whileRunner) {

            System.out.println("\n-1 Mehsullar uzerinde emeliyyat aparmaq\n" +
                    "-2 Satislar uzerinde emeliyyat aparmaq\n" +
                    "-3 Sistemden cixmaq");

            System.out.print("Type (waiting...): ");

            input = scanner.nextInt();

            switch (input) {
                case 1:
                    renderStageItems();
                    whileRunner = false;
                   break;
                case 2:
                    renderStageSales();
                    whileRunner = false;
                    break;
                case 3:
                    whileRunner = false;
                    break;
                default:
                    System.out.println("Input wrong number");
            }
        }
    }

    public static void renderStageItems() {

        int input = 0;
        boolean whileRunner = true;

        while (whileRunner) {

            System.out.println("\n  - 1 Yeni mehsul elave et  - userden yeni mehsul yaradilmasi ucun lazim olan melumatlari daxil edilmelidir\n" +
            "    - 2 Mehsul uzerinde duzelis et -  duzelis edilecek mehsulun code-u ve duzelis melumatlari daxil edilmelidir\n" +
            "    - 3 Mehsulu sil - mehsulu kodu daxil edilmelidir\n" +
            "    - 4 Butun mehsullari goster - butun mehsullar gosterilecek (kodu,adi,categoriyasi,sayi,qiymeti)\n" +
            "    - 5 Categoriyasina gore mehsullari goster - usere var olan kateqoriyalar gosteilecek ve onlar arasinda bir secim etmelidir ve secilmis kateqoriyadan olan butun mehsullar gosterilir (kodu,adi,categoriyasi,sayi,qiymeti)\n" +
            "    - 6 Qiymet araligina gore mehsullari goster - userden minmum ve maximum qiymetleri daxil etmesi istenilir ve hemin qiymet araliginda olan mehsullar gosterilir (kodu, adi,categoriyasi,sayi,qiymeti)\n" +
            "    - 7 Mehsullar arasinda ada gore axtaris et - useden text daxil etmesi istenilir ve adinda hemin text olan butun mehsullar gosterilir (kodu, adi,categoriyasi,sayi,qiymeti)");

            System.out.print("Type (waiting...): ");

            input = scanner.nextInt();

            switch (input) {
                case 1:
                    //;
                    whileRunner = false;
                    break;
                case 2:
                    //
                    whileRunner = false;
                    break;
                case 3:
                    //
                    whileRunner = false;
                    break;
                case 4:
                    //
                    whileRunner = false;
                    break;
                case 5:
                    //
                    whileRunner = false;
                    break;
                case 6:
                    //
                    whileRunner = false;
                    break;
                case 7:
                    //
                    whileRunner = false;
                    break;
                default:
                    System.out.println("Input wrond number");
            }
        }
    }

    public static void renderStageSales() {

        int input = 0;
        boolean whileRunner = true;

        while (whileRunner) {

            System.out.println("\n - 1 Yeni satis elave etmek - istifadeciden satis yaradilmasi ucun lazimi meulatlarin daxil edilmesi istenilir (mehsullarin kodlari)\n" +
            "    - 2 Satisdaki hansisa mehsulun geri qaytarilmasi( satisdan cixarilmasi) - userden satisin,cixarilacaq mehsulun ve sayinin daxil edilmesi istenilir\n" +
            "    - 3 Satisin silinmesi - satisin nomresine esasen silinmesi\n" +
            "    - 4 Butun satislarin ekrana cixarilmasi (nomresi,meblegi,mehsul sayi,tarixi)\n" +
            "    - 5 Verilen tarix araligina gore satislarin gosterilmesi - userden qebul edilen iki tarix araligindaki satislarin gosterilmesi (nomresi,meblegi,mehsul sayi,tarixi)\n" +
            "    - 6 Verilen mebleg araligina gore satislarin gosterilmesi - userden qebul edilen iki mebleg araligindaki satislarin gosterilmesi (nomresi,meblegi,mehsul sayi,tarixi)\n" +
            "    - 7 Verilmis bir tarixde olan satislarin gosterilmesi  - userden qebul edilmis bir tarixde olan satislarin gosterilmesi(nomresi,meblegi,mehsul sayi,tarixi)\n" +
            "    - 8 Verilmis nomreye esasen hemin nomreli satisin melumatlarinin gosterilmesi - userden qebul edilmis nomdereye esasen hemin nomreli satisin melumatlarinin gosterilmesi (nomresi,meblegi,mehsul sayi,tarixi, satis itemlari (nomresi,mehsul adi,sayi))\n" +
                    " - 9 Retrun -\"");

            System.out.print("Type (waiting...): ");

            input = scanner.nextInt();

            switch (input) {
                case 1:
                    renderAddReceipt();
                    whileRunner = false;
                    break;
                case 2:
                    //
                    whileRunner = false;
                    break;
                case 3:
                    //
                    whileRunner = false;
                    break;
                case 4:
                    //
                    whileRunner = false;
                    break;
                case 5:
                    //
                    whileRunner = false;
                    break;
                case 6:
                    //
                    whileRunner = false;
                    break;
                case 7:
                    //
                    whileRunner = false;
                    break;
                case 8:
                    //
                    whileRunner = false;
                    break;
                case 9:
                    whileRunner = false;
                    run(repository);
                    break;
                default:
                    System.out.println("Input wrond number");
            }
        }

    }

    public static void renderAddReceipt() {

        System.out.println("Item List: ");
        System.out.println(repository.getItems());
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter product ID and count: ");

        repository.addReceipt(scanner.nextLine());

        repository.getReceipts();
        run(repository);
    }


}
