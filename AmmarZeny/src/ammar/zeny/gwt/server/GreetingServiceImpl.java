package ammar.zeny.gwt.server;

import ammar.zeny.gwt.client.GreetingService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	public String getRoots(int x,int y,int z) throws IllegalArgumentException {
		double  ammar; String root1,root2;
	    String result;
		ammar =  Math.sqrt(y * y - 4 * x * z);
	if(ammar>0)
		{ 	root1 =(-y +  ammar) / (2*x)+" " ;
			root2 =(-y -  ammar) / (2*x)+" " ;
		   	result="Root1=  "+root1+"Root2=   "+root2;
	      	 return result;
	      	}
	
		else if(ammar==0)
		{root1 = (-y) / (2*x)+" " ;
		 result="Root=  "+root1;
		 return result;
		 	}
	
		else 
		{result="ERROR...invalid inputs";
		return result;
		}
	}

	
}
