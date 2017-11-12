package com.org.cf.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.cf.dao.SubmitConsentDAO;
import com.org.cf.dao.SubmitConsentDAOImpl;
import com.org.cf.model.Country;
import com.org.cf.model.DataOwnerPage;


/*
 * It is just a helper class which should be replaced by database implementation.
 * It is not very well written class, it is just used for demonstration.
 */
@Service
public class SubmitConsentImpl implements SubmitConsentService {

	@Autowired
	private SubmitConsentDAO consentDao;


	public SubmitConsentImpl() {
		super();

	}
	
	public String saveStandOut(DataOwnerPage owner){
		
		return consentDao.saveStandOut(owner);
	}
}
