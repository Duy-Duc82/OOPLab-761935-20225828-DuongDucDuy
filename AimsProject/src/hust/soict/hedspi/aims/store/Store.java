package hust.soict.hedspi.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class Store {
	public static final int MAX_ITEMS_IN_STORE = 1000;

	private List<Media> itemsInStore = new ArrayList<>();

	public void addMedia(Media media) {
		if (media == null) {
			return;
		}

		if (itemsInStore.size() >= MAX_ITEMS_IN_STORE) {
			System.out.println("The store is full");
			return;
		}

		itemsInStore.add(media);
		System.out.println("The media has been added to store");
	}

	public void addDVD(DigitalVideoDisc dvd) {
		addMedia(dvd);
	}

	public void removeDVD(DigitalVideoDisc dvd) {
		removeMedia(dvd);
	}

	public void removeMedia(Media media) {
		if (media == null) {
			return;
		}

		if (!itemsInStore.remove(media)) {
			System.out.println("The media was not found in store");
			return;
		}
		System.out.println("The media has been removed from store");
	}

	public List<Media> getItemsInStore() {
		return new ArrayList<>(itemsInStore);
	}

	public Media findById(int id) {
		for (Media media : itemsInStore) {
			if (media.getId() == id) {
				return media;
			}
		}
		return null;
	}

	public Media findByTitle(String title) {
		if (title == null) {
			return null;
		}

		for (Media media : itemsInStore) {
			String mediaTitle = media.getTitle();
			if (mediaTitle != null && mediaTitle.toLowerCase().contains(title.trim().toLowerCase())) {
				return media;
			}
		}
		return null;
	}
}

