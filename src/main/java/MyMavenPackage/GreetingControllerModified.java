package MyMavenPackage;

import java.util.concurrent.atomic.AtomicLong;
import java.net.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingControllerModified {
	  private static final String template = "Hello, %s!";
	    private final AtomicLong counter = new AtomicLong();

	    @RequestMapping("/myhost")
	    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
	    
	    try {
			InetAddress myadd=	InetAddress.getLocalHost();
			if(myadd!=null)
			{
				System.out.println(name+" : "+myadd.getHostName());
				name += "This request is served by " + myadd.toString();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
	    	
	        return new Greeting(counter.incrementAndGet(),
	                            String.format(template, name));
	    }
}