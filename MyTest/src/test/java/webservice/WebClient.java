package webservice;





import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;


public class WebClient {

    public static void main(String args[]) throws Exception{
    	  
        JaxWsDynamicClientFactory dcf =JaxWsDynamicClientFactory.newInstance();
        org.apache.cxf.endpoint.Client client =dcf.createClient("http://localhost:7001/nontax/test/user?wsdl");
        Object[] objects;
		try {
			objects = client.invoke("getUser","411001");
	        System.out.println("*****"+objects[0].toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    }
    
}