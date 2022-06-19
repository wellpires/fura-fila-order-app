package br.com.furafila.orderapp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import br.com.furafila.orderapp.dao.OrderDAO;
import br.com.furafila.orderapp.dao.mapper.ApprovedOrderDTORowMapper;
import br.com.furafila.orderapp.dto.ApprovedOrderDTO;

@Component
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<ApprovedOrderDTO> listApprovedOrders(Long establishmentId) {

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("establishmentId", establishmentId);

		StringBuilder query = new StringBuilder();
		query.append("select 																				");
		query.append("	c.id_comanda, 																		");
		query.append("	c.codigoPedido, 																	");
		query.append("	s.id_status , 																		");
		query.append("	s.status, 																			");
		query.append("	e.id_estabelecimento, 																");
		query.append("	e.razao_social, 																	");
		query.append("	e.cnpj, 																			");
		query.append("	cl.conjunto_locker_desc, 															");
		query.append("	l.id_locker , 																		");
		query.append("	l.locker_desc, 																		");
		query.append("	tl.desc_tipo_logradouro , 															");
		query.append("	lgr.nrocep, 																		");
		query.append("	lgr.logradouro, 																	");
		query.append("	lgr.latitude, 																		");
		query.append("	lgr.longitude,																		");
		query.append("	b.desc_bairro,																		");
		query.append("	cid.desc_cidade ,																	");
		query.append("	u.sigla_uf, 																		");
		query.append("	cli.nome, 																			");
		query.append("	cli.email  																			");
		query.append("from  pedidos p																		");
		query.append("inner join comanda c on p.id_comanda_fk = c.id_comanda								");
		query.append("inner join status s on s.id_status = c.id_status_fk									");
		query.append("inner join estabelecimento e on e.id_estabelecimento = c.id_estabelecimento_FK		");
		query.append("inner join cliente cli on cli.id_cliente = c.id_cliente_fk							");
		query.append("inner join pedido_locker pl on pl.id_pedido_fk = p.id_pedido							");
		query.append("inner join locker l on l.id_locker = pl.id_locker_fk									");
		query.append("inner join conjunto_locker cl on cl.id_conjunto_locker = l.id_conjunto_locker_fk		");
		query.append("inner join logradouro lgr on lgr.nrocep = cl.nrocep_fk								");
		query.append("inner join tipo_logradouro tl on tl.id_tipo_logradouro = lgr.id_tipo_logradouro_fk	");
		query.append("inner join bairro b on b.id_bairro = lgr.id_bairro_fk									");
		query.append("inner join cidade cid on cid.id_cidade = b.id_cidade_fk								");
		query.append("inner join uf u on u.id_uf = cid.id_uf_fk												");
		query.append("where c.id_estabelecimento_fk = :establishmentId and C.id_status_FK not in (8, 5)		");

		return jdbcTemplate.query(query.toString(), param, new ApprovedOrderDTORowMapper());
	}

}
