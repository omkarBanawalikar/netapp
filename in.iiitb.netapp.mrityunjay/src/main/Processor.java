package main;

import bean.House;

import bean.HouseLocation;

public class Processor {

	int lastHousePosition;
	House[][] houseArray;

	public Processor(int sizeOfMatrix) {
		super();
		lastHousePosition = sizeOfMatrix - 1;
		houseArray = new House[sizeOfMatrix][sizeOfMatrix];
	}

	public void init(int sizeOfMatrix, int[][] donationArray) {

		for (int row = 0; row <= lastHousePosition; row++) {
			for (int column = 0; column <= lastHousePosition; column++) {

				houseArray[row][column] = new House();
				houseArray[row][column].setHouseLocation(new HouseLocation(row,
						column));
				houseArray[row][column]
						.setHouseExpectedDonation(donationArray[row][column]);

				// setting the destination's house Cumulative field
				if (column == lastHousePosition && row == lastHousePosition) {
					houseArray[row][column]
							.setCumulativeDonation(houseArray[row][column]
									.getHouseExpectedDonation());
				}
			}
		}
	}

	public void updateStateofHousesAndstart() {

		for (int row = (int) lastHousePosition; row >= 0; row--) {
			for (int column = (int) lastHousePosition; column >= 0; column--) {
				calculateDonationForAdjacentTwoHouses(houseArray[row][column]);
			}
		}
	}

	private void calculateDonationForAdjacentTwoHouses(House house) {

		int xccor = (int) house.getHouseLocation().getXcoordinate();
		int yccor = (int) house.getHouseLocation().getYcoordinate();

		if (house.getHouseLocation().getXcoordinate() == lastHousePosition
				|| house.getHouseLocation().getYcoordinate() == lastHousePosition) {

			// for the top most row
			if (house.getHouseLocation().getXcoordinate() == lastHousePosition
					&& house.getHouseLocation().getYcoordinate() != lastHousePosition) {

				house.setNextHouse(houseArray[xccor][yccor + 1]);

				house.setCumulativeDonation(house.getHouseExpectedDonation()
						+ houseArray[xccor][yccor + 1].getCumulativeDonation());

			}
			// for the right most row
			if (house.getHouseLocation().getYcoordinate() == lastHousePosition
					&& house.getHouseLocation().getXcoordinate() != lastHousePosition) {

				house.setNextHouse(houseArray[xccor + 1][yccor]);

				house.setCumulativeDonation(house.getHouseExpectedDonation()
						+ houseArray[xccor + 1][yccor].getCumulativeDonation());

			}
		}
		// for all house except the topmost row and rightmost row
		else {

			House topHouse = houseArray[xccor + 1][yccor];
			House rightHouse = houseArray[xccor][yccor + 1];

			// if top house has more cumulative value
			if (topHouse.getCumulativeDonation() >= rightHouse
					.getCumulativeDonation()) {
				house.setNextHouse(houseArray[xccor + 1][yccor]);
				house.setCumulativeDonation(house.getHouseExpectedDonation()
						+ houseArray[xccor + 1][yccor].getCumulativeDonation());

			}// if the right house has more cumulative value
			else {
				house.setNextHouse(houseArray[xccor][yccor + 1]);
				house.setCumulativeDonation(house.getHouseExpectedDonation()
						+ houseArray[xccor][yccor + 1].getCumulativeDonation());

			}
		}
	}

	public int  getOutput() {
		int totalDonation = 0;
		House house = houseArray[0][0];
		while (house != (null)) {
			totalDonation+=house.getHouseExpectedDonation();
			System.out.println(house.getHouseExpectedDonation());
			house = house.getNextHouse();
		}
		
		return totalDonation;
	}
}
