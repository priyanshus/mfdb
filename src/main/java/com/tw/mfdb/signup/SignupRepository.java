package com.tw.mfdb.signup;

import org.springframework.data.jpa.repository.JpaRepository;

interface SignupRepository extends JpaRepository<SignupUser, String> {
}
