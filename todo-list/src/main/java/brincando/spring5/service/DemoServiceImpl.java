package brincando.spring5.service;

import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService{


    @Override
    public String getHelloMessage(String user) {
        return "Hello, ".concat(user);
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome to this Demo application";
    }
}
