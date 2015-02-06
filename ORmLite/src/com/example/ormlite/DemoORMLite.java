package com.example.ormlite;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.j256.ormlite.field.DatabaseField;

public class DemoORMLite {

	// Class name will be tablename Fields here
	@DatabaseField(generatedId = true, canBeNull = false)
	int _id;
	@DatabaseField(canBeNull = true)
	String first_name;
	@DatabaseField(canBeNull = true)
	String last_name;
	@DatabaseField(canBeNull = true)
	Date created;

	DemoORMLite() {
	}

	public DemoORMLite(String name, long date) {
		this.first_name = name;
		this.last_name = "ben rabie";
		this.created = new Date(date);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(_id);
		sb.append(", ").append(first_name);
		sb.append(", ").append(last_name);
		SimpleDateFormat dateFormatter = new SimpleDateFormat(
				"MM/dd/yyyy HH:mm:ss.S");
		sb.append(", ").append(dateFormatter.format(created));
		return sb.toString();
	}
}
