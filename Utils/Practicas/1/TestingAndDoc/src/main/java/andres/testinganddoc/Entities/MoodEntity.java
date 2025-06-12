package andres.testinganddoc.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mood")
public class MoodEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "mood", length = 50)
    private String mood;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

}