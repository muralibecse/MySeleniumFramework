package framework;

import org.w3c.dom.Element;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.openqa.selenium.remote.http.HttpMethod;
import org.openqa.selenium.remote.http.HttpRequest;
import org.w3c.dom.Document;

public class CommonFunctions {
	
	public static void main(String []a){
		CreateXML("test.xml");
		
	}
	
	public static void SendXMLRequest(String XMLRequest){
		
		
		
	}
	
	public synchronized static void createChildElements(Element ChildElement,Element ChildItems,String Description,String stepStatus){
		Element ChildElement1 = ChildElement;
		try{
		ChildElement = document.createElement("TestStep");
		ChildElement.setAttribute("Description", Description);
		ChildElement.setAttribute("stepStatus",stepStatus);
		ChildElement1.appendChild(ChildElement);

		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public synchronized static void createTestCase(Element TestCaseRootElement ,String TestCaseName,String TestCaseDescription){
		Element TestCaseElement = null;
		
		try{
			
			TestCaseElement=document.createElement("TestCase");
			TestCaseElement.setAttribute("TestCaseName", TestCaseName);
			TestCaseElement.setAttribute("TestCaseDescription", TestCaseDescription);
			TestCaseRootElement.appendChild(TestCaseElement);
			
		}catch(Exception e){
			
		}
		
		
	}
	
	
	
	
	 
	 static Document document = null;


	public synchronized static void CreateXML(String filePath){
		DocumentBuilderFactory dbFactory = null;
		Element rootElement = null;
		DocumentBuilder dBuilder = null;
		//Document document = null;
		Element childElement1 = null;
		Element ChildItems = null;
		
		try{
		//Document Builder Factory
		dbFactory = DocumentBuilderFactory.newInstance();
		dBuilder = dbFactory.newDocumentBuilder();
		document = dBuilder.newDocument();
		//parent Element
		rootElement = document.createElement("TestSuite");
		document.appendChild(rootElement);
		
		//adding child to the parent element
		childElement1 = document.createElement("TestCase");
		childElement1.setAttribute("TestCaseName", "TestCase1");
		childElement1.setAttribute("TestCaseDescription", "This is a sample file to check on the xml preparation");
		rootElement.appendChild(childElement1);
		
		createTestCase(rootElement,"TestCase1","TestCase1 Description");
		
		
		createChildElements(childElement1,ChildItems,"i am step1","passed");
		createChildElements(childElement1,ChildItems,"i am step2","passed");
		createChildElements(childElement1,ChildItems,"i am step3","Failed");


		//write the content into xml file
		
		TransformerFactory transFactory = TransformerFactory.newInstance();
		Transformer transformer = transFactory.newTransformer();
		DOMSource dom = new DOMSource(document);
		StreamResult strResult = new StreamResult(new File(filePath));
		transformer.transform(dom, strResult);
		System.out.println("File Saved");
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}
		
		
	}
	
	
	public static void TestCasePass(String Description,String TestCaseStatus){
		
		
		
	}
}
