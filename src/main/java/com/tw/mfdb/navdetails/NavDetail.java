package com.tw.mfdb.navdetails;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "NAV_HISTORY")
@SecondaryTable(name = "SCHEME_DETAILS", pkJoinColumns = @PrimaryKeyJoinColumn(name = "scheme_code"))
public class NavDetail {
    private Date date;
    @Id
    private Long schemeCode;

    @Column(name = "scheme_name", table = "scheme_details")
    private String schemeName;
    private String isinDivPayout;
    private String isinDivReinvestment;
    private Float nav;
    private Float repurchasePrice;
    private Float salePrice;

    NavDetail() {}

    public NavDetail(Date date, Long schemeCode, String schemeName, String isinDivPayout, String isinDivReinvestment,
                     Float nav, Float repurchasePrice, Float salePrice) {
        this.date = date;
        this.schemeCode = schemeCode;
        this.schemeName = schemeName;
        this.isinDivPayout = isinDivPayout;
        this.isinDivReinvestment = isinDivReinvestment;
        this.nav = nav;
        this.repurchasePrice = repurchasePrice;
        this.salePrice = salePrice;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getSchemeCode() {
        return schemeCode;
    }

    public void setSchemeCode(Long schemeCode) {
        this.schemeCode = schemeCode;
    }

    public String getIsinDivPayout() {
        return isinDivPayout;
    }

    public void setIsinDivPayout(String isinDivPayout) {
        this.isinDivPayout = isinDivPayout;
    }

    public String getIsinDivReinvestment() {
        return isinDivReinvestment;
    }

    public void setIsinDivReinvestment(String isinDivReinvestment) {
        this.isinDivReinvestment = isinDivReinvestment;
    }

    public Float getNav() {
        return nav;
    }

    public void setNav(Float nav) {
        this.nav = nav;
    }

    public Float getRepurchasePrice() {
        return repurchasePrice;
    }

    public void setRepurchasePrice(Float repurchasePrice) {
        this.repurchasePrice = repurchasePrice;
    }

    public Float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Float salePrice) {
        this.salePrice = salePrice;
    }
}
