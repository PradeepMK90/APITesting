package org.ratestngpojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Datum {

	    public int id;
	    public String address_code;
	    public int user_id;
	    public String first_name;
	    public String last_name;
	    public String mobile;
	    public String apartment;
	    public String address;
	    public int country_id;
	    public int state_id;
	    public int city_id;
	    public String zipcode;
	    public Object lat;
	    public Object lng;
	    @JsonProperty("default") 
	    public int mydefault;
	    public String status;
	    public String address_type;
	    public String created_at;
	    public String updated_at;
	    public String city;
	    public String state;
	    public String country;
	    public int is_selected;
		public int getId() {
			return id;
		}
		public String getAddress_code() {
			return address_code;
		}
		public int getUser_id() {
			return user_id;
		}
		public String getFirst_name() {
			return first_name;
		}
		public String getLast_name() {
			return last_name;
		}
		public String getMobile() {
			return mobile;
		}
		public String getApartment() {
			return apartment;
		}
		public String getAddress() {
			return address;
		}
		public int getCountry_id() {
			return country_id;
		}
		public int getState_id() {
			return state_id;
		}
		public int getCity_id() {
			return city_id;
		}
		public String getZipcode() {
			return zipcode;
		}
		public Object getLat() {
			return lat;
		}
		public Object getLng() {
			return lng;
		}
		public int getMydefault() {
			return mydefault;
		}
		public String getStatus() {
			return status;
		}
		public String getAddress_type() {
			return address_type;
		}
		public String getCreated_at() {
			return created_at;
		}
		public String getUpdated_at() {
			return updated_at;
		}
		public String getCity() {
			return city;
		}
		public String getState() {
			return state;
		}
		public String getCountry() {
			return country;
		}
		public int getIs_selected() {
			return is_selected;
		}
		public void setId(int id) {
			this.id = id;
		}
		public void setAddress_code(String address_code) {
			this.address_code = address_code;
		}
		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}
		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}
		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public void setApartment(String apartment) {
			this.apartment = apartment;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public void setCountry_id(int country_id) {
			this.country_id = country_id;
		}
		public void setState_id(int state_id) {
			this.state_id = state_id;
		}
		public void setCity_id(int city_id) {
			this.city_id = city_id;
		}
		public void setZipcode(String zipcode) {
			this.zipcode = zipcode;
		}
		public void setLat(Object lat) {
			this.lat = lat;
		}
		public void setLng(Object lng) {
			this.lng = lng;
		}
		public void setMydefault(int mydefault) {
			this.mydefault = mydefault;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public void setAddress_type(String address_type) {
			this.address_type = address_type;
		}
		public void setCreated_at(String created_at) {
			this.created_at = created_at;
		}
		public void setUpdated_at(String updated_at) {
			this.updated_at = updated_at;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public void setState(String state) {
			this.state = state;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public void setIs_selected(int is_selected) {
			this.is_selected = is_selected;
		}

}
