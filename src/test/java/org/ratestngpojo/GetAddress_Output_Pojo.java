package org.ratestngpojo;

import java.util.ArrayList;

public class GetAddress_Output_Pojo {

public int status;
public String message;
public ArrayList<Datum> data;
public int getStatus() {
	return status;
}
public String getMessage() {
	return message;
}
public ArrayList<Datum> getData() {
	return data;
}
public void setStatus(int status) {
	this.status = status;
}
public void setMessage(String message) {
	this.message = message;
}
public void setData(ArrayList<Datum> data) {
	this.data = data;
}

}
