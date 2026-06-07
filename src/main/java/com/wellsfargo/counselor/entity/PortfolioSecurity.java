package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "portfolio_security")
public class PortfolioSecurity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long portfolioSecurityId;

    // Many portfolio-security records belong to one portfolio
    @ManyToOne
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    // Many portfolio-security records reference one security
    @ManyToOne
    @JoinColumn(name = "security_id", nullable = false)
    private Security security;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private Date purchaseDate;

    @Column(nullable = false)
    private float purchasePrice;

    public PortfolioSecurity(Portfolio portfolio, Security security, int quantity,
                             Date purchaseDate, float purchasePrice) {
        this.portfolio = portfolio;
        this.security = security;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
    }

    protected PortfolioSecurity() {}

    // Getters and Setters

    public long getPortfolioSecurityId() {
        return portfolioSecurityId;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}
