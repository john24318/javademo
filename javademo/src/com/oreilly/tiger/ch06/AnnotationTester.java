package com.oreilly.tiger.ch06;

public class AnnotationTester {

	@com.oreilly.tiger.ch06.InProgress
	@GroupTODO(severity = GroupTODO.Severity.CRITICAL, item = "Figure out the amount of interest per month", assignedTo = "Brett McLaughlin", dateAssigned = "04-26-2004")
	public void calculateInterest(float amount, float rate) {
		// Need to finish this method later
	}
}