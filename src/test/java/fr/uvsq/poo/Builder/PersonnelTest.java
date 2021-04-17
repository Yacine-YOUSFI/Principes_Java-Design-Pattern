package fr.uvsq.poo.Builder;


import fr.uvsq.poo.Builder_Composite_Iterator.NumeroTelephone;
import fr.uvsq.poo.Builder_Composite_Iterator.Personnel;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PersonnelTest {
	private Personnel pers;

	@Before()
	public void setUp() {
		pers = new Personnel.Builder("Jean", "Jacques", "Plombier")
				.dateNaissance(LocalDate.parse("1970-01-01", DateTimeFormatter.ISO_DATE))
				.addNumeroTelephone(new NumeroTelephone("Perso", "0666666666", "0766"))
				.addNumeroTelephone(new NumeroTelephone("Fax", "0612345678", "0766"))
				.build();
	}


	@Test()
	public void testGetNom() {
		assertEquals(pers.getNom(), "Jean");
	}

	@Test()
	public void testGetPrenom() {
		assertEquals(pers.getPrenom(), "Jacques");
	}

	@Test()
	public void testGetFonction() {
		assertEquals(pers.getfonction(), "Plombier");
	}

	@Test()
	public void testGetDateNaissance() {
		assertEquals(pers.getdate(),
				LocalDate.parse("1970-01-01", DateTimeFormatter.ISO_DATE));
	}

	@Test()
	public void testGetNumerosTelephone() {
		List<NumeroTelephone> numList = new ArrayList<NumeroTelephone>();
		numList.add(new NumeroTelephone("Perso", "0666666666", "0766"));
		numList.add(new NumeroTelephone("Fax", "0612345678", "0766"));
		assertEquals(pers.getNumerosTelephone(), numList);
	}
}
