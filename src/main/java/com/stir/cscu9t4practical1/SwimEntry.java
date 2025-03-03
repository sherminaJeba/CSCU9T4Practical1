package com.stir.cscu9t4practical1;

public class SwimEntry extends Entry {

	private String where;

	public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String whr) {

		super(n, d, m, y, h, min, s, dist);
		this.where = whr;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String whr) {
		this.where = whr;
	}
	
	 public String getEntry () {
		   String result = getName()+" ran " + getDistance() + " km in "
		             +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+" in" + getWhere() +"\n";
		   return result;
		  } //getEntry
}