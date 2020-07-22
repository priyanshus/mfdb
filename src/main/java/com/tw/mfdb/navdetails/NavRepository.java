package com.tw.mfdb.navdetails;

import com.tw.mfdb.navdetails.repository.INavCustomRespository;
import com.tw.mfdb.schemedetails.Scheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

interface NavRepository extends JpaRepository<NavDetail, Long>, INavCustomRespository {
}