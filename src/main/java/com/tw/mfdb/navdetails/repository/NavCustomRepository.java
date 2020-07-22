package com.tw.mfdb.navdetails.repository;

import com.tw.mfdb.navdetails.NavDetail;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;

@Repository
@Transactional(readOnly = true)
public class NavCustomRepository implements INavCustomRespository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public NavDetail findBySchemeCodeAndDate(Long schemeCode, Date date) {
        Query query = entityManager.createNativeQuery("SELECT n.scheme_code, s.scheme_name, n.isin_div_payout, n.isin_div_reinvestment, n.nav, n.repurchase_price, n.sale_price\n" +
                "FROM NAV_HISTORY n \n" +
                "INNER JOIN SCHEME_DETAILS s ON n.scheme_code = s.scheme_code where n.scheme_code=? and n.date=?", NavDetail.class);
        query.setParameter(1, schemeCode);
        query.setParameter(2, date);
        return (NavDetail) query.getSingleResult();
    }
}
