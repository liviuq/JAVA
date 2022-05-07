package app;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "countries", schema = "public", catalog = "postgres")
public class Country {
  @Basic
  @Column(name = "id")
  private Integer id;
  @Basic
  @Column(name = "name")
  private String name;
  @Basic
  @Column(name = "code")
  private String code;
  @Basic
  @Column(name = "continent")
  private Integer continent;

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

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Integer getContinent() {
    return continent;
  }

  public void setContinent(Integer continent) {
    this.continent = continent;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Country country = (Country) o;
    return Objects.equals(id, country.id) && Objects.equals(name, country.name) && Objects.equals(code, country.code) && Objects.equals(continent, country.continent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, code, continent);
  }
}
