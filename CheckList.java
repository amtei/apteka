import java.util.List;

public class CheckList {//получение общей суммы из листа
    public void checkList(MedicineDTO medicineDTO){
List<Medicine>medicines=medicineDTO.getMed();
medicines.stream()
        .map(Medicine::getSum)
        .reduce( Integer::sum)
        .ifPresent(System.out::println);

    }
}
