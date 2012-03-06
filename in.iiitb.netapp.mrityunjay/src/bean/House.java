package bean;

public class House {

	long houseExpectedDonation ;
	long CumulativeDonation = -1;
	HouseLocation houseLocation = new HouseLocation();
	House nextHouse = null ;	
	
	
	
	public long getHouseExpectedDonation() {
		return houseExpectedDonation;
	}
	public void setHouseExpectedDonation(long houseExpectedDonation) {
		this.houseExpectedDonation = houseExpectedDonation;
	}
	public long getCumulativeDonation() {
		return CumulativeDonation;
	}
	public void setCumulativeDonation(long cumulativeDonation) {
		CumulativeDonation = cumulativeDonation;
	}
	public HouseLocation getHouseLocation() {
		return houseLocation;
	}
	public void setHouseLocation(HouseLocation houseLocation) {
		this.houseLocation = houseLocation;
	}
	public House getNextHouse() {
		return nextHouse;
	}
	public void setNextHouse(House direction) {
		this.nextHouse = direction;
	}	
}
