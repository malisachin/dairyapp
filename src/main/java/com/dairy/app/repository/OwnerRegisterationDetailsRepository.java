package com.dairy.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dairy.app.model.OwnerRegisterationDetails;

@Repository
public interface OwnerRegisterationDetailsRepository extends JpaRepository<OwnerRegisterationDetails, Integer>{

}
