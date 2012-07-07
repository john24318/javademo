package com.oreilly.tiger.ch07;

import java.util.LinkedList;
import java.util.List;

public class GuitarManufacturerList extends LinkedList<String> {

	public GuitarManufacturerList() {
		super();
	}

	public boolean add(String manufacturer) {
		if (manufacturer.indexOf("Guitars") == -1) {
			return false;
		} else {
			super.add(manufacturer);
			return true;
		}
	}
}