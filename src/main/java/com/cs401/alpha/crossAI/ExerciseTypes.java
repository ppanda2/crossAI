package com.cs401.alpha.crossAI;

public class ExerciseTypes {

	public String name;
	public Types types; // = new ArrayList<Types>();

	public ExerciseTypes(String name, Types types) {
		super();
		this.name = name;
		this.types = types;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Types getTypes() {
		return types;
	}

	public void setTypes(Types types) {
		this.types = types;
	}

	@Override
	public String toString() {
		return "ExerciseTypes [name=" + name + ", types=" + types + "]";
	}

}
