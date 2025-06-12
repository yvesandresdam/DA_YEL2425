package andres.testinganddoc.Entities;

import jakarta.persistence.*;


@Entity
@Table(name = "names")
@NamedQuery(
        name = "NameEntity.findByMoodIndex",
        query = "SELECT n.name FROM NameEntity n WHERE n.idMood = :mood"
)
public class NameEntity {
    @Id
    @Column(name = "id_names", nullable = false)
    private Integer id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "id_mood", nullable = false)
    private Integer idMood;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdMood() {
        return idMood;
    }

    public void setIdMood(Integer idMood) {
        this.idMood = idMood;
    }

}