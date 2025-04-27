package Util;

import DAO.MedicineDao;
import DAO.PersonDao;
import entity.Medicine;
import entity.Person;

import java.util.Optional;

public class TEST {
    public static void main(String[] args) {
        var personDao = PersonDao.getInstance();
        var person = new Person();
        person.setName("vasya");
        person.setLastname("vasechkin");
        person.setWallet(122);

        var saved = personDao.save(person);

        var instance = MedicineDao.getInstance();
        var medicine = new Medicine();
        var cefanol = instance.findByName("cefanol");


        System.out.println(cefanol);

//        var instance = MedicineDao.getInstance();
//    var medicine = new Medicine();
//    medicine.setPrimaryelement("cwfazolin");
//    medicine.setMed_name("cefanol");
//    medicine.setPrice(2121);
//   // var save = instance.save(medicine);
//        var byName = instance.findByName("cefanol");


        //  var delete = instance.delete(1L);


    }
}
