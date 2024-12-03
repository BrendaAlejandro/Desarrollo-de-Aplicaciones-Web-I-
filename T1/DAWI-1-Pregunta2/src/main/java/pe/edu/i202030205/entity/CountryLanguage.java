package pe.edu.i202030205.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "countrylanguage")
public class CountryLanguage {
    @EmbeddedId
    private CountryLanguageId id;

    @Column(name = "IsOfficial")
    private boolean isOfficial;

    @Column(name = "Percentage")
    private double percentage;

    // Relación con Country
    @ManyToOne
    @MapsId("countryCode")
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code")
    private Country country;

    // Getters y Setters
    public CountryLanguageId getId() { return id; }
    public void setId(CountryLanguageId id) { this.id = id; }
    public boolean isOfficial() { return isOfficial; }
    public void setOfficial(boolean official) { isOfficial = official; }
    public double getPercentage() { return percentage; }
    public void setPercentage(double percentage) { this.percentage = percentage; }
    public Country getCountry() { return country; }
    public void setCountry(Country country) { this.country = country; }
}
