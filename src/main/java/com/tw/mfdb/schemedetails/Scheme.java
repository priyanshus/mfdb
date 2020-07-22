package com.tw.mfdb.schemedetails;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "SCHEME_DETAILS")
public class Scheme {
    @Id
    @Column(name = "scheme_code")
    private Long schemeCode;

    @Column(name = "scheme_name")
    private String schemeName;

    public Scheme() {}

    public Scheme(Long schemeCode, String schemeName) {
        this.schemeCode = schemeCode;
        this.schemeName = schemeName;
    }

    public Long getSchemeCode() {
        return schemeCode;
    }

    public void setSchemeCode(Long schemeCode) {
        this.schemeCode = schemeCode;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }
}
