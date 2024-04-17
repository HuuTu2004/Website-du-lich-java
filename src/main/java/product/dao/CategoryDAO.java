package product.dao;

import java.util.List;
import product.entites.Category;

public interface CategoryDAO {
    public Category findById(int id);
    public boolean insert(Category category);
    public boolean update(Category category);
    public boolean delete(Integer category);
    public List<Category> getAllCategories();
}
