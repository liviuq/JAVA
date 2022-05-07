package app;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "continents", schema = "public", catalog = "postgres")
public class Continent {
  @Basic
  @Column(name = "id")
  private Integer id;
  @Basic
  @Column(name = "name")
  private String name;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Continent continent = (Continent) o;
    return Objects.equals(id, continent.id) && Objects.equals(name, continent.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }
}
