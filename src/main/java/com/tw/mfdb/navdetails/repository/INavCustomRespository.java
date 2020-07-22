package com.tw.mfdb.navdetails.repository;

import com.tw.mfdb.navdetails.NavDetail;

import java.util.Date;

public interface INavCustomRespository {
    NavDetail findBySchemeCodeAndDate(Long schemeCode, Date date);
}
