package com.example.demo.grpc.client;

import com.proto.prototest.TextMessage;
import com.proto.prototest.TextRequest;
import com.proto.prototest.TextResponse;
import com.proto.prototest.TextServiceGrpc;
import com.proto.prototest.TextServiceGrpc.TextServiceBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ProtoTestClient {

	public static void main(String[] args) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8888)
														.usePlaintext()
														.build();
		
		TextServiceBlockingStub blockingStub = TextServiceGrpc.newBlockingStub(channel);
		
		System.out.println("gRPC client connected to gRPC server");
		
		TextMessage textMsg = TextMessage.newBuilder()
										.setText("World")
										.build();
		
		TextRequest request = TextRequest.newBuilder()
										.setReqTextMsg(textMsg)
										.build();
		
		TextResponse response = blockingStub.protoTest(request);
		
		System.out.println("server reponse: " + response.getResTextMsg().getText());
		
		channel.shutdown();
		System.out.println("gRPC client shutdown");
	}
}
