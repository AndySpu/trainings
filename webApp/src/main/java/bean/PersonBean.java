package bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import persistence.BaseRepository;
import persistence.model.Person;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("person")
@RequestScoped
public class PersonBean implements Serializable {

    private static final long serialVersionUID = 1L;

    final Logger logger = LoggerFactory.getLogger(PersonBean.class);

    @Inject
    BaseRepository baseRepository;

    private String firstName;
    private String lastName;
    
    List<Person> listPersons = new ArrayList<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void save() {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        Person persistedPerson = baseRepository.persistPerson(person);
        listPersons.add(persistedPerson);
    }
}
