package com.cs401.alpha.crossAI;

import java.util.ArrayList;
import java.util.List;

public class AboutusBusinesslogic {

	public List<Aboutus> getAboutusList()
	{
		List<Aboutus> listus = new ArrayList<>();
		listus.add(new Aboutus("Pratysuh Panda", "fe8394"));
		listus.add(new Aboutus("Tony Stark", "1234"));
		
		return listus;
	}
}
