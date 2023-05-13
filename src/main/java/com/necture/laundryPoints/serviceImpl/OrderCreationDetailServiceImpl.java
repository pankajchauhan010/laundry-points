package com.necture.laundryPoints.serviceImpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.necture.laundryPoints.entity.OrderCreationDetail;
import com.necture.laundryPoints.repository.OrderCreationDetailRepository;
import com.necture.laundryPoints.service.OrderCreationDetailService;

@Service
public class OrderCreationDetailServiceImpl implements OrderCreationDetailService {

	@Autowired
	OrderCreationDetailRepository orderCreationRepo;

	@Override
	public List<OrderCreationDetail> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderCreationDetail findById(UUID id) {
		Optional<OrderCreationDetail> orderData = orderCreationRepo.findById(id);
		if(orderData.isPresent()) {
			return orderData.get();
		}
		return new OrderCreationDetail();
	}

	@Override
	public OrderCreationDetail save(OrderCreationDetail data) {
		OrderCreationDetail saveData = orderCreationRepo.save(data);
		if(Objects.nonNull(saveData.getId())) {
			return saveData;
		}
		return new OrderCreationDetail();
	}

	@Override
	public void delete(OrderCreationDetail object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(UUID id) {
		// TODO Auto-generated method stub

	}

}
