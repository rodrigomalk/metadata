package org.esfinge.metadata.foo.annotation.test;

import static org.junit.Assert.assertTrue;

import org.esfinge.metadata.foo.validator.Validator;
import org.esfinge.metadata.foo.validator.implementation.ValidatorFieldVisibilityForbidden;
import org.junit.Before;
import org.junit.Test;

public class TestFieldVisibilityForbidden {
	
	private Validator validator;
	
	@Before
	public void init(){
		validator = new Validator(new ValidatorFieldVisibilityForbidden());
	}
		
	@Test
	public void testWithSuccess() throws Exception {
		Person p = new Person("Jason", "32198732143", 15);			
		boolean validated = validator.validateAnnotationInObject(p);			
		assertTrue(validated);
	}
	
	@Test(expected = Exception.class)
	public void testWithError() throws Exception {
		PersonWithError p = new PersonWithError("Piper", "65345186593", 13);	
		validator.validateAnnotationInObject(p);
	}

}
