package com.blogs.grpc.server.controllers.grpc;

import com.blogs.user.GetUserRequest;
import com.blogs.user.User;
import com.blogs.user.UserServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@Slf4j
public class UserService extends UserServiceGrpc.UserServiceImplBase {
    @Override
    public void get(GetUserRequest request, StreamObserver<User> responseObserver) {
        log.info("Get user request with id {}", request.getId());
        var response = User.newBuilder().setId(1L).setName("testuser").setEmail("testuser@blog.com").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
