package dev.service;

import java.util.List;

import dev.domain.Store;
import dev.repository.StoreRepository;

public class StoreService {
	
	private static StoreService service = null;
	private StoreRepository stdao = new StoreRepository();
	
	private StoreService() {}
	public static StoreService getInstance() {
		if (service == null) {
			service = new StoreService();
		}
		return service;
	}
	
	public List<Store> storeList() {
		return stdao.getList();
	}
	
	public List<Store> acceptstoreList() {
		return stdao.getacceptList();
	}
	
	public boolean removeStore(String store_name) {
		return stdao.deleteStore(store_name);
	}
	public boolean updateStore(String store_name) {
		return stdao.updateStore(store_name);
	}

}
