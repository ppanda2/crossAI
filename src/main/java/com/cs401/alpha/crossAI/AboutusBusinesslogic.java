package com.cs401.alpha.crossAI;

import java.util.ArrayList;
import java.util.List;

public class AboutusBusinesslogic {

	public List<Aboutus> getAboutusList() {
		List<Aboutus> listus = new ArrayList<>();
		listus.add(new Aboutus("Pratysuh Panda", "fe8394"));
		listus.add(new Aboutus("Raoni Marcelino", ""));
		listus.add(new Aboutus("Jeremy Lee", ""));
		listus.add(new Aboutus("Faisal Alnafea", ""));
		listus.add(new Aboutus("Ahmo Ahmetovic", ""));

		return listus;
	}
}
