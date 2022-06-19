package br.com.furafila.orderapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.furafila.orderapp.dao.OrderDAO;
import br.com.furafila.orderapp.dto.ApprovedOrderDTO;
import br.com.furafila.orderapp.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;

	@Override
	public List<ApprovedOrderDTO> listApprovedOrders(Long establishmentId) {
		return orderDAO.listApprovedOrders(establishmentId);
	}

}
