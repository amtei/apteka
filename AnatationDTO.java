import java.util.HashMap;
import java.util.Map;

public class AnatationDTO {

///класс принимает главный составной элемент и показывает аналоги
    Map<String,String>map=new HashMap<>();

    public void setMap(String name,String anation) {
      map.put(name, anation);
    }

    public Map<String, String> getMap() {
        return map;
    }
}
