import java.security.Key;
import java.util.*;

public class StackDTO {


    ///осуществляет поиск по индексу показывает колличество остатка приход и расход
    private Map<Integer, Integer> maping = new HashMap<>();

    public void setMaping(Integer index, Integer value) {
        maping.put(index, value);
    }

    public Map<Integer, Integer> getMaping() {
        return maping;
    }


//принимает значение пришедшего продукта

    public void sumStack(MedicineDTO medicineDTO) {
        List<Medicine> med = medicineDTO.getMed();

        for (Medicine medicine : med) {
          medicine.getIndex();
            maping.computeIfPresent(medicine.getIndex(),(k,v)->v+1);
        }
        }
    //отнимает значение пришедшего продукта
        public void subtractionStack(MedicineDTO medicineDTO){
        List<Medicine>medicines=medicineDTO.getMed();
            for (Medicine medicine : medicines) {
                medicine.getIndex();
                maping.computeIfPresent(medicine.getIndex(),(k,v)->v-1);
            }
            }
        }






