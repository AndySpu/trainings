package persistence.model;

import javax.persistence.*;

@Entity
@Table(schema = "master", name = "master")
@NamedQuery(name = "select", query = "FROM Master")
public class Master {

    @Id
    @Column(name = "id_master")
    private int id;

    @Column(name = "info")
    private String info;

    public Master() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
