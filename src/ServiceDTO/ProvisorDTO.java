package ServiceDTO;

import entity.Medicine;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProvisorDTO {

    List<Medicine> medicineList=new ArrayList();


    public void MedPriceList() {
        var reduce = medicineList.stream()
                .map(Medicine::getPrice)
                .reduce(0,Integer::sum);
        System.out.println(reduce);
    }


    public List<Medicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(Medicine medicine) {
        medicineList.add(medicine);
    }
}








