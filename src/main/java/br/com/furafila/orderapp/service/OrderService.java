package br.com.furafila.orderapp.service;

import java.util.List;

import br.com.furafila.orderapp.dto.ApprovedOrderDTO;

public interface OrderService {

	List<ApprovedOrderDTO> listApprovedOrders(Long establishmentId);

}
