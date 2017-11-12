package com.org.cf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.org.cf.model.Country;
import com.org.cf.model.DataOwnerPage;

@Repository
public class SubmitConsentDAOImpl implements SubmitConsentDAO {
	
	
	 private JdbcTemplate jdbcTemplate;
	 int count=0;
	 
	 @Autowired
	 public void setDataSource(DataSource dataSource) {
	  this.jdbcTemplate = new JdbcTemplate(dataSource);
	 }
	

		public String saveStandOut(DataOwnerPage owner) {
			
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			//DataOwnerPage dop = new DataOwnerPage();
			owner.setStartTime(timestamp.toString());
			
		System.out.println("Type111111="+owner.getConsentType()+" "+"ST22222="+owner.getStartTime()+" "+"ET33333="+owner.getExpiaryDate()+" "+"O4444="+owner.getOption1()+" "+"O155555="+owner.getOption2());
		 
		if(owner.getOption1()==null){
		System.out.println("In OP1 null");
		 count = jdbcTemplate.update(
			    "INSERT INTO DATA_OWNER_KEY_CONTACT(consentType,startTime,expiaryDate,option2)VALUES(?,?,?,?)", new Object[] {
			    		owner.getConsentType(), owner.getStartTime(),owner.getExpiaryDate(),owner.getOption2()});
		}else if(owner.getOption2()==null){
			System.out.println("In OP2 null");
			count = jdbcTemplate.update(
				    "INSERT INTO DATA_OWNER_KEY_CONTACT(consentType,startTime,expiaryDate,option1)VALUES(?,?,?,?)", new Object[] {
				    		owner.getConsentType(), owner.getStartTime(),owner.getExpiaryDate(),owner.getOption1()});
			
		}
		
		System.out.println("COUNT=="+count);
		
		if(1 == count)
			return "Player creation is SUCCESS";
        else
            return "Player creation is FAILURE";
		
		
		
	}


		

}
