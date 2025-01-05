package model;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")

@NamedQuery(
        name = "Category.SelectAllCategories",
        query = "from Category"
)

@NamedQuery(
        name = "Category.SelectCategoryWithId",
        query = "from Category where id = :id"
)

@NamedQuery(
        name = "Category.SelectCategoryWithName",
        query = "from Category where categoryName = :categoryName"
)


public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categories_id_gen")
    @SequenceGenerator(name = "categories_id_gen", sequenceName = "categories_category_id_seq", allocationSize = 1)
    @Column(name = "category_id", nullable = false)
    private Integer id;

    @Column(name = "category_name", nullable = false, length = 50)
    private String categoryName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}