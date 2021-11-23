package com.ot.micropay.order.service;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.data.cassandra.core.query.Query;
import org.springframework.stereotype.Service;


import com.ot.micropay.order.model.Order;
import com.ot.micropay.order.model.Product;
import com.ot.micropay.order.repository.OrderRepository;
import com.ot.micropay.order.service.datafetcher.AllOrdersDataFetcher;
import com.ot.micropay.order.service.datafetcher.OrderDataFetcher;
import com.ot.micropay.order.service.datafetcher.OrderMutationResolver;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class GraphqlOrderService {
	private static Logger logger = LoggerFactory.getLogger(GraphqlOrderService.class);
	private OrderRepository orderRepository;
	private AllOrdersDataFetcher allOrdersDataFetcher;
	private OrderDataFetcher orderDataFetcher;
	private OrderMutationResolver orderMutation;
	@Value("classpath:./graphql/orders.graphqls")
	Resource resource;
	private GraphQL graphQL;

	@Autowired
	public GraphqlOrderService(OrderRepository orderRepository, AllOrdersDataFetcher allOrdersDataFetcher,
			OrderMutationResolver orderMutation, OrderDataFetcher orderDataFetcher) {
		this.orderRepository = orderRepository;
		this.allOrdersDataFetcher = allOrdersDataFetcher;
		this.orderDataFetcher = orderDataFetcher;
		this.orderMutation = orderMutation;

		/*
		 * Product product=new Product(UUID.randomUUID(),"soap",1,45.0); List<Product>
		 * pList=new ArrayList<Product>(); pList.add(product);
		 * logger.info("productName: "+pList.iterator().next().getProductName()); Order
		 * order=new Order(UUID.randomUUID(),"Soap buy",pList,Instant.now());
		 * 
		 * logger.info("OrderName: "+order.getOrderDescription());
		 * this.orderRepository.save(order);
		 */
	}

	@PostConstruct
	private void loadSchema() throws IOException {
		logger.info("Entering loadSchema@GraphqlOrderService");
		// Get the graphql file
		File file = resource.getFile();
		// Parse SchemaF
		TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(file);
		RuntimeWiring runtimeWiring = buildRuntimeWiring();
		GraphQLSchema graphQLSchema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
		
		//RuntimeWiring.newRuntimeWiring().type("Mutation",typeWiring -> typeWiring.typeResolver(new OrderMutationResolver(orderRepository))).build();
				
		graphQL = GraphQL.newGraphQL(graphQLSchema).build();

	}

	private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
        		
                .type("Query", typeWiring -> typeWiring
                .dataFetcher("allOrders", allOrdersDataFetcher)
                .dataFetcher("order", orderDataFetcher)).
                    build();
        
       
    }

	public GraphQL getGraphQL() {
		return graphQL;
	}
}