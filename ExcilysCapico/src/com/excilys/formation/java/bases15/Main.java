package com.excilys.formation.java.bases15;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

public class Main {
	public static void main(String[] args) throws IOException, JAXBException,
			SAXException {
		Veterinaire veto = new Veterinaire();

		veto.add(new Chat("Chat-1", "coco", new Adresse(Adresse.type.AVENUE,
				37, "Claude Debussy")));
		veto.add(new Chat("Chat-2", "garou", new Adresse(Adresse.type.RUE, 21,
				"Chanteraines")));

		veto.add(new Chien("Chien-1", "belle", new Adresse(Adresse.type.RUE,
				42, "Margueritte")));
		veto.add(new Chien("Chien-2", "sebastien", new Adresse(
				Adresse.type.BOULVARD, 2, "Saint-Jacques")));

		System.out.println(veto);

		// Creation de la validation XSD
		JAXBContext context = JAXBContext.newInstance(Veterinaire.class);
		context.generateSchema(new SchemaOutputResolver() {
			@Override
			public Result createOutput(String namespaceUri,
					String suggestedFileName) throws IOException {
				return new StreamResult(new File("src/output/veto.xsd"));
			}
		});

		// Marshalling/enregistrer l'objet
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty("jaxb.encoding", "UTF-8");
		marshaller.setProperty("jaxb.formatted.output", true);
		marshaller.marshal(veto, new File("src/output/veto.xml"));

		// Unmarshalling/charger l'objet
		SchemaFactory sf = SchemaFactory
				.newInstance("http://www.w3.org/2001/XMLSchema");
		Schema sc = sf.newSchema(new File("src/output/veto.xsd"));

		Unmarshaller unmarshaller = context.createUnmarshaller();
		unmarshaller.setSchema(sc);

		Veterinaire vetoBak = (Veterinaire) unmarshaller.unmarshal(new File(
				"src/output/veto.xml"));

		System.out.println(vetoBak);
	}
}
