package com.cs401.alpha.crossAI;

import java.util.ArrayList;
import java.util.List;

public class AboutusBusinesslogic {

	public List<Aboutus> getAboutusList() {
		List<Aboutus> listus = new ArrayList<>();
		listus.add(new Aboutus("Pratysuh Panda", "fe8394"));
		listus.add(new Aboutus("Raoni Marcelino", "si8832"));
		listus.add(new Aboutus("Jeremy Lee", "dx6535"));
		listus.add(new Aboutus("Faisal Alnafea", "kp5663"));
		listus.add(new Aboutus("Ahmo Ahmetovic", "ga8796"));

		return listus;
	}
}
