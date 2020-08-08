package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="covidinfo", schema = "public" )
public class Covid {
	
	@Column(name = "state")
	private String state_name;
	@Id
	@Column(name="id")
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int id;
	@Column(name = "last_one_day")
	private String LastOneDay;
	@Column(name = "last_two_days")
	private String LastTwoDays;
	@Column(name = "last_three_days")
	private String LastThreeDays;
	@Column(name = "last_four_days")
	private String LastFourDays;
	@Column(name = "last_five_days")
	private String LastFiveDays;
	@Column(name = "last_six_days")
	private String LastSixDays;
	@Column(name = "last_week")
	private String LastWeek;
	@Column(name = "last_ten_days")
	private String LastTenDays;
	@Column(name = "last_fifteen_days")
	private String LastFifteenDays;
	@Column(name = "last_twenty_days")
	private String LastTwentyDays;
	@Column(name = "last_month")
	private String LastMonth;
	
	public String getState_name() {
		return state_name;
	}
	public int getId() {
		return id;
	}
	public String getLastOneDay() {
		return LastOneDay;
	}
	public String getLastTwoDays() {
		return LastTwoDays;
	}
	public String getLastThreeDays() {
		return LastThreeDays;
	}
	public String getLastFourDays() {
		return LastFourDays;
	}
	public String getLastFiveDays() {
		return LastFiveDays;
	}
	public String getLastSixDays() {
		return LastSixDays;
	}
	public String getLastWeek() {
		return LastWeek;
	}
	public String getLastTenDays() {
		return LastTenDays;
	}
	public String getLastFifteenDays() {
		return LastFifteenDays;
	}
	public String getLastTwentyDays() {
		return LastTwentyDays;
	}
	public String getLastMonth() {
		return LastMonth;
	}


}
