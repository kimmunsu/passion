package com.springapp.guestBook;

import java.util.List;

public class GuestBookService {
	
	public GuestBookService(){}
	
	public List<GuestBook> write(GuestBook guestBook){
		return GuestBookModel.getInstance().add(guestBook);
	}
	
	public GuestBook getGuestBook(int guestBookId) throws NotExistGuestBookException{
		GuestBook guestBook = GuestBookModel.getInstance().findByGuestBookId(guestBookId);
		if(guestBook == null)
			throw new NotExistGuestBookException();
		else
			return guestBook;
	}
	
	public List<GuestBook> getGuestBookList(){
		return GuestBookModel.getInstance().getGuestBookList();
	}
	
	public List<GuestBook> getGuestBookList(int fromIndex, int toIndex){
		return GuestBookModel.getInstance().getGuestBookList(fromIndex, toIndex);
	}
	
	public GuestBook updateGuestBook(GuestBook guestBook) throws NotExistGuestBookException{
		return GuestBookModel.getInstance().updateGuestBook(guestBook);
	}
	
	public List<GuestBook> updateGuestBookNGetList(GuestBook guestBook) throws NotExistGuestBookException{
		GuestBookModel.getInstance().updateGuestBook(guestBook);
		return getGuestBookList();
	}
	
	public List<GuestBook> updateGuestBookNGetList(GuestBook guestBook, int fromIndex, int toIndex) throws NotExistGuestBookException{
		GuestBookModel.getInstance().updateGuestBook(guestBook);
		return getGuestBookList(fromIndex, toIndex);
	}
	
	public List<GuestBook> deleteGuestBook(int guestBookId) throws NotExistGuestBookException{
		return GuestBookModel.getInstance().deleteGuestBook(guestBookId);
	}
}
