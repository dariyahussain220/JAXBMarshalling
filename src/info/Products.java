package info;

import java.io.File;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Products")
public class Products {

	private String description;

	private String name;

	@XmlElement(required=false, name= "Description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement(required=true, name= "Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
		try {
			String path = "<Products><Name>Hello</Name><Order>1</Order></Products>";
			File file = new File(path);
			JAXBContext jContext = JAXBContext.newInstance(Products.class);
			Unmarshaller unmarshallerObj = jContext.createUnmarshaller();
			Products person = (Products) unmarshallerObj.unmarshal(new StringReader(path));
//			Products person = (Products) unmarshallerObj.unmarshal(file);
			System.out.println(person.getName()+" "+person.getDescription());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
