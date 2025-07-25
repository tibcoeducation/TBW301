/**
 ** BW406: Logic to calculate Shipping and shipping Charges *
 ** TIBCO Education Programs 2014 ***
 **/
package com.tibco.tibedu.shipping;

public class CalcCharges {
	String priority = "LOW";
	double orderAmount = 0.0;
	double shippingCost = 0.0;

	public CalcCharges() {	}

	public double calculateshippingCost(String priority, Double orderAmount) throws Exception {
	 if(priority.equalsIgnoreCase("HIGH"))
		{
			if(orderAmount<=1000)
				shippingCost = 40;
			else 
				shippingCost = orderAmount*4/100;
		}
		else if(priority.equalsIgnoreCase("MEDIUM"))
		{
			if(orderAmount<=1000)
				shippingCost = 30;
			else 
				shippingCost = orderAmount*3/100;
		}
		else
		{
			if(orderAmount<=1000)
				shippingCost = 20;
			else 
				shippingCost = orderAmount*2/100;
		}
	return shippingCost;
	}
}
