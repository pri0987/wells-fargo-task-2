package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "security")
public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long securityId;

    @Column(nullable = false)
    private String name;

    // e.g. "Stock", "Bond", "Mutual Fund", "ETF"
    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String description;

    // Many securities can appear in many portfolios (via join table)
    @OneToMany(mappedBy = "security", cascade = CascadeType.ALL)
    private List<PortfolioSecurity> portfolioSecurities;

    public Security(String name, String category, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
    }

    protected Security() {}

    // Getters and Setters

    public long getSecurityId() {
        return securityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PortfolioSecurity> getPortfolioSecurities() {
        return portfolioSecurities;
    }

    public void setPortfolioSecurities(List<PortfolioSecurity> portfolioSecurities) {
        this.portfolioSecurities = portfolioSecurities;
    }
}
