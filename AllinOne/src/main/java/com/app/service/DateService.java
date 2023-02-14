package com.app.service;

import java.util.List;

import com.app.model.DateFormate;

public interface DateService {

	DateFormate saveDate(DateFormate dateFormate);

	List<DateFormate> getDate();

}

