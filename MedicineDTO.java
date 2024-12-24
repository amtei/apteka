import java.util.ArrayList;
import java.util.List;

public class MedicineDTO {
    ///список приходящих лекарств


    List<Medicine> med = new ArrayList<>();

    public void setMed(Medicine medicine) {
        med.add(medicine);
    }

    public List<Medicine> getMed() {
        return med;
    }

}




