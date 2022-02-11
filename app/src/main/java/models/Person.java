package models;

import java.util.List;

public class Person {

    private String name;
    private String phone;
    private String mail;
    private String pass;
    private String id;
    private List<Equipment> equipments;
    private List<Hour> HOURS;

    public Person(String name, String phone, String mail, String id) {
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.id = id;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person() {}

    public Person(String name, String phone, String mail, String id, List<Equipment> equipments, List<Hour> HOURS) {
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.id = id;
        this.equipments = equipments;
        this.HOURS = HOURS;
    }



    public List<Hour> getHOURS() {
        return HOURS;
    }

    public void setHOURS(List<Hour> HOURS) {
        this.HOURS = HOURS;
    }





    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }




    public void addEqp(Equipment equipmentl){
        this.equipments.add(equipmentl);

    }

    public void delEqp(Equipment equipmentl){
        this.equipments.remove(equipmentl);
    }

}




