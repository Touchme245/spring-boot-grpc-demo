package ru.grpc.demo;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import ru.grpc.demo.proto.HelloRequest;
import ru.grpc.demo.proto.SimpleGrpc;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public ApplicationRunner commandLineRunner(@GrpcClient("greetingsService")SimpleGrpc.SimpleBlockingStub simpleBlockingStub){
		return new ApplicationRunner(){
			@Override
			public void run(ApplicationArguments args) throws Exception{
					var res = simpleBlockingStub.sayHello(HelloRequest.newBuilder().setName("  is the best").build());
					System.out.println(res);

			}
		};
	}

}
