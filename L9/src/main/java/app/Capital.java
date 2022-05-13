package app;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "capitals", schema = "public", catalog = "postgres")
public class Capital {
  @Basic
  @Column(name = "id")
  private Integer id;
  @Basic
  @Column(name = "country")
  private Integer country;
  @Basic
  @Column(name = "name")
  private String name;
  @Basic
  @Column(name = "latitude")
  private Double latitude;
  @Basic
  @Column(name = "longitude")
  private Double longitude;
  @Basic
  @Column(name="code")
  private String code;
  @Basic
  @Column(name="continent")
  private String continent;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getCountry() {
    return country;
  }

  public void setCountry(Integer country) {
    this.country = country;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Capital capital = (Capital) o;
    return Objects.equals(id, capital.id) && Objects.equals(country, capital.country) && Objects.equals(name, capital.name) && Objects.equals(latitude, capital.latitude) && Objects.equals(longitude, capital.longitude) && Objects.equals(code, capital.code) && Objects.equals(continent, capital.continent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, country, name, latitude, longitude, code, continent);
  }
}
