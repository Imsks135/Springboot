package com.cgi.springlist;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	 private List<Object> lists = new ArrayList<Object>();
	    public String toString(){
	      return lists.toString();
	    }
	  public List<Object> getLists() {
	    return lists;
	  }
	  public void setLists(List<Object> lists) {
	    this.lists = lists;
	  }
}
