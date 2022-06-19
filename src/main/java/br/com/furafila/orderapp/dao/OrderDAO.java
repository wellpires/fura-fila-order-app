package br.com.furafila.orderapp.dao;

import java.util.List;

import br.com.furafila.orderapp.dto.ApprovedOrderDTO;

public interface OrderDAO {

	List<ApprovedOrderDTO> listApprovedOrders(Long establishmentId);

}
