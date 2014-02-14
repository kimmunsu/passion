package com.springapp.guestBook;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

public class GuestBookModel {

	private List<GuestBook> guestBookList = new ArrayList<GuestBook>();
	private static volatile GuestBookModel INSTANCE;
	
	private GuestBookModel(){}
	
	public static GuestBookModel getInstance(){
		if(INSTANCE == null) synchronized (GuestBookModel.class) {
			if(INSTANCE == null)
				INSTANCE = new GuestBookModel();
		}
		return INSTANCE;
	}
	
	public List<GuestBook> add(GuestBook guestBook){
		guestBook.setRegDate(DateTime.now());
		this.guestBookList.add(guestBook);
		return this.guestBookList;
	}
	
	public GuestBook findByGuestBookId(int guestBookId){
		int guestBookListCount = this.guestBookList.size();
		for(int index=0; index<guestBookListCount; index++){
			if(this.guestBookList.get(index).getGuestBookId() == guestBookId)
				return this.guestBookList.get(index);
		}
		return null;
	}
	
	public List<GuestBook> getGuestBookList(){
		return this.guestBookList;
	}
	
	public List<GuestBook> getGuestBookList(int fromIndex, int toIndex){
		return this.guestBookList.subList(fromIndex, toIndex);
	}
	
	public GuestBook updateGuestBook(GuestBook newGuestBook) throws NotExistGuestBookException{
		int guestBookListCount = this.guestBookList.size();
		for(int index=0; index<guestBookListCount; index++){
			if(this.guestBookList.get(index).getGuestBookId() == newGuestBook.getGuestBookId()){
				this.guestBookList.get(index).setContent(newGuestBook.getContent());
				this.guestBookList.get(index).setRegDate(DateTime.now());
				return this.guestBookList.get(index);
			}
		}
		throw new NotExistGuestBookException();
	}
	
	public List<GuestBook> deleteGuestBook(int guestBookId) throws NotExistGuestBookException{
		int guestBookListCount = this.guestBookList.size();
		for(int index=0; index<guestBookListCount; index++){
			if(this.guestBookList.get(index).getGuestBookId() == guestBookId){
				this.guestBookList.remove(index);
				return this.guestBookList;
			}
		}
		throw new NotExistGuestBookException();
	}
}
