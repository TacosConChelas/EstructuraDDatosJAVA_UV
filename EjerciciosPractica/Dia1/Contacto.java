package EjerciciosPractica.Dia1;

public class Contacto {
    
    public String nameUser;
    public long phoneNumberUser;
    public String addressUser;

    public String getNameUser(){
        return this.nameUser;
    }
    public long getPhoneNumberUser(){
        return this.phoneNumberUser;
    }
    public String getAddressUser(){
        return this.addressUser;
    } 
    
    public void setNameUser(String a){   this.nameUser = a; }
    public void setPhoneNumberUser(long a){   this.phoneNumberUser = a; }
    public void setAddressUser(String a){   this.addressUser = a; }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "El contacto es: \n  Nombre del contacto: " + nameUser + "\n  El numero de telefono es:" + phoneNumberUser
                + "\n  La dirección es: " + addressUser;
    }
}
