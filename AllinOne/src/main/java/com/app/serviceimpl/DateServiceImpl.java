package com.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.DateFormate;
import com.app.repository.DateRepository;
import com.app.service.DateService;
@Service
public class DateServiceImpl implements DateService{

	@Autowired DateRepository dr;
	
	@Override
	public DateFormate saveDate(DateFormate dateFormate) {
		
		return dr.save(dateFormate);
	}

	@Override
	public List<DateFormate> getDate() {
		
		return dr.findAll();
	}

}
