package maven.p01.aop;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindingResult;

import maven.p01.entity.Users;

@Aspect
@Configuration
public class LogAspect {
	private org.apache.logging.log4j.Logger logger = LogManager.getLogger(LogAspect.class);
    private OutputStream ops;
    //@Pointcut("execution(public * webadv.example.controller.HomeController.check(..))")
    //public void webLog(){}
    
    //@Before("webLog()")
    public LogAspect() {
    	try{
    		Path path=Paths.get("17205124-ysb.log");
    		File file=path.toFile();
    		if(!file.exists()) 	file.createNewFile();
    		ops=Files.newOutputStream(path, StandardOpenOption.WRITE);
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    
    @Before("execution(public * maven.p01.rest.LoginController.checkLogin(..)) && args(user,result,..)")
    public void doBefore(Users user, BindingResult result) throws Throwable {
    	logger.info(String.format("Account:%s,Password:%s , login %s.", user.getAccount(),user.getPassword(),result.hasErrors()?"failed":"succeeded"));
    	String log=String.format(String.format("Account:%s, Password:%s ,login %s.", user.getAccount(),user.getPassword(),result.hasErrors()?"failed":"succeeded"));
    	ops.write(log.getBytes(Charset.forName("UTF-8")));
    	ops.close();
    }    
}