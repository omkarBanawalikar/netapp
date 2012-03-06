package bean;

public class HouseLocation {

	long xcoordinate;
	long ycoordinate;

	public HouseLocation(long xcoordinate, long ycoordinate) {
		super();
		this.xcoordinate = xcoordinate;
		this.ycoordinate = ycoordinate;
	}

	public HouseLocation() {
		// TODO Auto-generated constructor stub
	}

	public long getXcoordinate() {
		return xcoordinate;
	}

	public void setXcoordinate(long xcoordinate) {
		this.xcoordinate = xcoordinate;
	}

	public long getYcoordinate() {
		return ycoordinate;
	}

	public void setYcoordinate(long ycoordinate) {
		this.ycoordinate = ycoordinate;
	}

}
