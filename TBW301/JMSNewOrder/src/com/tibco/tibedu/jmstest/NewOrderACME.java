package com.tibco.tibedu.jmstest;

//Step 1. Import the necessary Jars
import javax.jms.*;
import javax.naming.*;
import java.util.Hashtable;

public class NewOrderACME {
	
		public static void main(String[] args) {
			String 					destinationName= null;
			Context 				jndiContext = null;
			ConnectionFactory		cFactory = null;
			Connection				conn = null;
			Session					session = null;
			Destination 			myDest=null;
			MessageProducer			myProd = null;
			TextMessage				msg = null;

			if (args.length<5)	{
				System.out.println("Usage: java NewOrderACME <CustID> <SKU1> <Qy1> <SKU2> <Qty2>");
				System.exit(1);
			}

			destinationName = "ACME.NewOrder";
			String Priority	    = " <ns0:Priority>HIGH</ns0:Priority>";
			String OrderDate	= " <ns0:OrderDate>2014-08-08T11:11:12.484-08:00</ns0:OrderDate>";
			System.out.println("destination is: "+ destinationName);
			
			String CustomerID	= " <ns0:CustomerID>"+ args[0] + "</ns0:CustomerID>";
			String ItemSKU	    = " <ns0:ItemSKU>" + args[1] + "</ns0:ItemSKU>";
			String Quantity		= " <ns0:Quantity>" + args[2] + "</ns0:Quantity>";
			String ItemSKU2	    = " <ns0:ItemSKU>" + args[3] + "</ns0:ItemSKU>";
			String Quantity2	= " <ns0:Quantity>" + args[4] + "</ns0:Quantity>";
			

			try	{
				Hashtable<String,String> env = new Hashtable<String,String>();
				env.put(Context.INITIAL_CONTEXT_FACTORY,"com.tibco.tibjms.naming.TibjmsInitialContextFactory");
				env.put(Context.PROVIDER_URL,"tcp://localhost:7222");
				jndiContext = new InitialContext(env);
				cFactory = (ConnectionFactory)jndiContext.lookup("GenericConnectionFactory");
				}catch (NamingException e)	{
				System.out.println("Failed JNDI InitialContext with tibjmsnaming://localhost:7222. Error = " + e.toString());
			}

			try	{
				//**** Create Connection, Session, producer
				conn = cFactory.createConnection();
				session = conn.createSession(false,Session.AUTO_ACKNOWLEDGE);
				myDest = (Destination)jndiContext.lookup(destinationName);
				myProd = session.createProducer(myDest);

				msg = session.createTextMessage();
				String xmlString = "<?xml version='1.0' encoding='UTF-8'?>"
				           + "<ns0:NewOrderInfo xmlns:ns0='http://www.tibco.com/schemas/testschemas/Schema.xsd'>";
				xmlString = xmlString + CustomerID + Priority + OrderDate + "<ns0:LineItems>"+ItemSKU + Quantity 
						   + "</ns0:LineItems>";
				xmlString = xmlString + "<ns0:LineItems>" + ItemSKU2 + Quantity2 + "</ns0:LineItems> </ns0:NewOrderInfo>";
				msg.setText(xmlString);

				//Send message
				System.out.println("Sending " + msg);
				myProd.send(msg);
			}
			catch (NamingException e) {
				System.out.println("Could not create or send message: " + e);
				System.exit(1);
			}
			catch (JMSException e) {
				System.out.println("Exception in send message: " + e);
				System.exit(1);
			}
			finally {
				if (conn != null)
				try {	conn.close();}
				catch(JMSException e) {   System.out.println("Exception: " + e);	}
			}
		}
	}


