package com.example.demo.grpc.server;


import com.proto.prototest.TextMessage;
import com.proto.prototest.TextRequest;
import com.proto.prototest.TextResponse;
import com.proto.prototest.TextServiceGrpc.TextServiceImplBase;

import io.grpc.stub.StreamObserver;

public class ProtoTestServiceImpl extends TextServiceImplBase{

	@Override
	public void protoTest(TextRequest request, StreamObserver<TextResponse> responseObserver) {
		TextMessage reqTextMsg = request.getReqTextMsg();
		
		System.out.println("Text from client : " + reqTextMsg.getText());
		
		TextMessage resTextMsg = TextMessage.newBuilder()
											.setText("Hello " + reqTextMsg.getText())
											.build();
		
		TextResponse response = TextResponse.newBuilder()
											.setResTextMsg(resTextMsg)
											.build();
		
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
	
}
