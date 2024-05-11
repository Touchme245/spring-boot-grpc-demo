package ru.grpc.demo.service;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import ru.grpc.demo.proto.HelloReply;
import ru.grpc.demo.proto.HelloRequest;
import ru.grpc.demo.proto.SimpleGrpc;

@GrpcService
public class HelloService extends SimpleGrpc.SimpleImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver){
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello" + request.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

}
