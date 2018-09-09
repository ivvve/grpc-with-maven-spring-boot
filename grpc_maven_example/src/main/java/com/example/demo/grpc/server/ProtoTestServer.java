package com.example.demo.grpc.server;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class ProtoTestServer {

	public static void main(String[] args) throws IOException, InterruptedException {
		Server server = ServerBuilder.forPort(8888)
									.addService(new ProtoTestServiceImpl())
									.build();
		
		server.start();
		System.out.println("gRPC server started");
		
		Runtime.getRuntime().addShutdownHook(new Thread( () -> {
			server.shutdown();
			System.out.println("gRPC server shutdown");
		} ));
		
		server.awaitTermination();
	}
}
