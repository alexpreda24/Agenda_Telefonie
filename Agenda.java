import java.io.Serializable;
import java.util.*;

public class Agenda implements Serializable {
    private static List<Contact> contactList = new LinkedList<>();
    private Criteriu criteriu = Criteriu.DUPA_NUME;

    public void addContact(Contact c){
        if(!contactList.contains(c))
            contactList.add(c);
    }

    public void setCriteriu(Criteriu criteriu) {

        this.criteriu = criteriu;
    }

    public Criteriu getCriteriu() {
        return criteriu;
    }

    public List<Contact> getContactList() {
        return contactList;
    }




    public void ordoneazaList(int forma){
        switch (criteriu){
            case DUPA_NUME:
                if(forma == 1)
                    Collections.sort(contactList, (o1, o2) -> o1.getName().compareTo(o2.getName()));
                else
                    Collections.sort(contactList, (o1, o2) -> o2.getName().compareTo(o1.getName()));
                break;
            case DUPA_PRENUME:
                if(forma == 1)
                    Collections.sort(contactList, (o1, o2) -> o1.getPrenume().compareTo(o2.getPrenume()));
                else
                    Collections.sort(contactList, (o1, o2) -> o2.getPrenume().compareTo(o1.getPrenume()));
                break;
            case DUPA_NASTERE:
                if(forma == 1)
                    Collections.sort(contactList, (o1, o2) -> o1.compareToDate(o2));
                else
                    Collections.sort(contactList, (o1, o2) -> o2.compareToDate(o1));
                break;
            case DUPA_TELEFON:
                if(forma == 1)
                    Collections.sort(contactList, (o1, o2) -> o1.getPhoneNumberString().compareTo(o2.getPhoneNumberString()));
                else
                    Collections.sort(contactList, (o1, o2) -> o2.getPhoneNumberString().compareTo(o1.getPhoneNumberString()));
                break;
        }
    }

}
