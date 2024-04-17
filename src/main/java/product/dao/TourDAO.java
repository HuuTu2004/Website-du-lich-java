package product.dao;

import java.util.List;

import product.entites.Tour;

public interface TourDAO {
    Tour findById(int id);
    boolean insert(Tour tour);
    boolean update(Tour tour);
    boolean delete(Integer tour);
    List<Tour> getAllTours();
    List<Tour> getToursByCategory(int categoryId);
	List<Tour> getAllTourStatus();
	List<Tour> getToursByName(String n);
}
