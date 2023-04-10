package com.stir.cscu9t4practical1;

public class CycleEntry extends Entry {

	private String terrain;
	private String tempo;

	public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String ter, String tem) {
		super(n, d, m, y, h, min, s, dist);
		this.terrain = ter;
		this.tempo = tem;
	}

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String ter) {
		this.terrain = ter;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tem) {
		this.tempo = tem;
	}
	
	 public String getEntry () {
		   String result = getName()+" ran " + getDistance() + " km in "
		             +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+" " + getTempo() +" "+getTerrain()+"\n";
		   return result;
		  } //getEntry

}