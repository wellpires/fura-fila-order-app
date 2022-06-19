package br.com.furafila.orderapp.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.furafila.orderapp.builder.ApprovedOrderDTOBuilder;
import br.com.furafila.orderapp.dto.ApprovedOrderDTO;

public class ApprovedOrderDTORowMapper implements RowMapper<ApprovedOrderDTO> {

	@Override
	public ApprovedOrderDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

		return new ApprovedOrderDTOBuilder().bucketId(rs.getLong("id_comanda")).number(rs.getString("codigoPedido"))
				.statusId(rs.getLong("id_status")).status(rs.getString("status"))
				.establishmentId(rs.getLong("id_estabelecimento")).corporateName(rs.getString("razao_social"))
				.cnpj(rs.getString("cnpj")).lockerGroupName(rs.getString("conjunto_locker_desc"))
				.lockerId(rs.getLong("id_locker")).lockerName(rs.getString("locker_desc"))
				.addressTypeName(rs.getString("desc_tipo_logradouro")).postalCode(rs.getInt("nrocep"))
				.addressName(rs.getString("logradouro")).latitude(rs.getDouble("latitude"))
				.longitude(rs.getDouble("longitude")).districtName(rs.getString("desc_bairro"))
				.cityName(rs.getString("desc_cidade")).postalAbbreviation(rs.getString("sigla_uf"))
				.customerName(rs.getString("nome")).customerEmail(rs.getString("email")).build();
	}

}
