package Model;

public class Owner {

    private String name;
    private String surname;

    public Owner(String name,String surname){
        this.name=name;
        this.surname=surname;
    }

    public String toString(){
        return "Właścicielem konta jest: " + name + " " + surname;
    }
}
