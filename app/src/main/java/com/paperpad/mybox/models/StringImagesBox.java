/**
 * 
 */
package com.paperpad.mybox.models;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**for list lien_images de {@link MyBox}
 * @author euphordev02
 *
 */
@DatabaseTable(tableName = "string-images-box")
public class StringImagesBox {

	@DatabaseField(generatedId = true)
	int id;
	
	@DatabaseField(foreign= true)
	private MyBox myBox;
	
	@DatabaseField(canBeNull = false, dataType = DataType.STRING)
	private String string;
	
	/**
	 * 
	 */
	public StringImagesBox() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 */
	public StringImagesBox(String str) {
		this.string = str;
	}
	/**
	 * @return the string
	 */
	public String getString() {
		return string;
	}
	/**
	 * @param string the string to set
	 */
	public void setString(String string) {
		this.string = string;
	}


	public MyBox getMyBox() {
		return myBox;
	}

	public void setMyBox(MyBox myBox) {
		this.myBox = myBox;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
