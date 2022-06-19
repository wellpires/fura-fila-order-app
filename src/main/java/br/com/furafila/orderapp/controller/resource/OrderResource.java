package br.com.furafila.orderapp.controller.resource;

import org.springframework.http.ResponseEntity;

import br.com.furafila.orderapp.response.ApprovedOrdersResponse;

public interface OrderResource {

	ResponseEntity<ApprovedOrdersResponse> listApprovedOrders(Long establishmentId);

}
