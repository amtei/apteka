import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)  {
        MedicineDTO medicineDTO=new MedicineDTO();
        System.out.println(medicineDTO);
        medicineDTO.setMed(new Medicine("marka","ampicilin",123,1));
        medicineDTO.setMed(new Medicine("marka","ampicilin",123,2));
        medicineDTO.setMed(new Medicine("marka","ampicilin",123,3));
        medicineDTO.setMed(new Medicine("marka","ampicilin",123,4));
       StackDTO stackDTO=new StackDTO();
       stackDTO.setMaping(1,1);
        stackDTO.setMaping(2,8);
        stackDTO.setMaping(3,12);
        stackDTO.setMaping(4,66);
         stackDTO.sumStack(medicineDTO);
        stackDTO.sumStack(medicineDTO);
        System.out.println(stackDTO.getMaping());
        stackDTO.subtractionStack(medicineDTO);
        System.out.println();
        System.out.println(stackDTO.getMaping());
        CheckList checkList=new CheckList();
        checkList.checkList(medicineDTO);




        }
    }
