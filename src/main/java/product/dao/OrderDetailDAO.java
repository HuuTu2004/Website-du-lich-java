package product.dao;

import java.util.List;

import product.entites.OrderDetail;

public interface OrderDetailDAO {
	boolean saveOrderDetail(OrderDetail orderDetail);

	boolean updateOrderDetail(OrderDetail orderDetail);

	boolean deleteOrderDetail(long orderDetailId);
	List<OrderDetail> getListOrder(long userId);
	OrderDetail getOrderDetailById(Integer orderDetailId);

	List<OrderDetail> getAllListOrder(Boolean status);
}
