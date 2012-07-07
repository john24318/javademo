package com.wangyao.quickstart.decouple.impl;

import com.wangyao.quickstart.decouple.IOutputGenerator;

public class JsonOutputGenerator implements IOutputGenerator {

	public void generateOutput() {
		System.out.println("Json Output Generator");
	}
}
