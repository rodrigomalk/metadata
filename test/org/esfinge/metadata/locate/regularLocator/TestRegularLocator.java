package org.esfinge.metadata.locate.regularLocator;

import static org.junit.Assert.*;

import java.lang.annotation.Annotation;
import org.esfinge.metadata.locate.RegularLocator;
import org.esfinge.metadata.locate.regularLocator01.ForTestRegularLocatorWithoutAnnotations;
import org.junit.Test;

public class TestRegularLocator {
	private RegularLocator locator = new RegularLocator();	
	
	//CT01
	@Test
	public void CT01() {
		Annotation an = locator.findMetadata(ForTestRegularLocatorWithoutAnnotations.class, Transaction.class);
		assertNull(an);
		assertFalse(an instanceof Transaction);
	}
	
	//CT02
	@Test
	public void CT02() throws NoSuchMethodException, SecurityException {
		Annotation an = locator.findMetadata(ForTestRegularLocatorWithoutAnnotations.class.getMethod("method", null),
				Transaction.class);
		assertNull(an);
		assertFalse(an instanceof Transaction);
	}
		
	//CT03	
	@Test
	public void CT03() throws NoSuchFieldException, SecurityException {
		Annotation an = locator.findMetadata(ForTestRegularLocatorWithoutAnnotations.class.getField("attribute"),
				Transaction.class);
		assertNull(an);
		assertFalse(an instanceof Transaction);
	}

	//CT04
	@Test
	public void CT04() {
		Annotation an = locator.findMetadata(ForTestRegularLocatorWithoutAnnotations.class.getPackage(),
				Transaction.class);
		assertNull(an);
		assertFalse(an instanceof Transaction);
	}

	
	//CT05
	@Transaction
	public class Class05{
		
	}
	
	@Test
	public void CT05() {
		Annotation an = locator.findMetadata(Class05.class, Transaction.class);
		assertNotNull(an);
		assertTrue(an instanceof Transaction);
	}
	
	
	//CT06
	public class Class06{
		@Transaction
		public void method(){
			
		}				
	}
	
	@Test
	public void CT06() throws NoSuchMethodException, SecurityException {
		Annotation an = locator.findMetadata(
				Class06.class.getMethod("method", null), Transaction.class);
		assertNotNull(an);
		assertTrue(an instanceof Transaction);
	}
	
	//CT07
	public class Class07{
		@Transaction
		public String attribute;
		
		public void method(){
			
		}				
	}
	
	@Test
	public void CT07() throws NoSuchFieldException {
		Annotation an = locator.findMetadata(
				Class07.class.getField("attribute"), Transaction.class);
		assertNotNull(an);
		assertTrue(an instanceof Transaction);
	}

	//CT08		
	@Test
	public void CT08() throws NoSuchFieldException {
		Annotation an = locator.findMetadata(Class08.class.getPackage(), Transaction.class);
		assertNotNull(an);
		assertTrue(an instanceof Transaction);
	}


}
