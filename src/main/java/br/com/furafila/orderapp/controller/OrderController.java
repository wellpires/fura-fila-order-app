package br.com.furafila.orderapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.furafila.orderapp.controller.resource.OrderResource;
import br.com.furafila.orderapp.dto.ApprovedOrderDTO;
import br.com.furafila.orderapp.response.ApprovedOrdersResponse;
import br.com.furafila.orderapp.service.OrderService;

@RestController
@RequestMapping("orders")
public class OrderController implements OrderResource {

	@Autowired
	private OrderService orderService;

	@Override
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApprovedOrdersResponse> listApprovedOrders(
			@RequestParam("establishmentId") Long establishmentId) {

		List<ApprovedOrderDTO> approvedOrderDTOs = orderService.listApprovedOrders(establishmentId);

		return ResponseEntity.ok(new ApprovedOrdersResponse(approvedOrderDTOs));
	}

}
