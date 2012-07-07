package com.wangyao.quickstart.decouple.impl;

import com.wangyao.quickstart.decouple.IOutputGenerator;

public class CsvOutputGenerator implements IOutputGenerator {

	public void generateOutput() {
		System.out.println("Csv Output Generator");
	}
}
