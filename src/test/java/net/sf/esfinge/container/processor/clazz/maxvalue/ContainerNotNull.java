package net.sf.esfinge.container.processor.clazz.maxvalue;

import java.util.List;

import net.sf.esfinge.metadata.AnnotationPropertyValidator;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.Processors;
import net.sf.esfinge.metadata.annotation.validator.NotNull;
import net.sf.esfinge.metadata.annotation.validator.ToValidateProperty;
import net.sf.esfinge.metadata.container.ContainerTarget;

@ContainerFor(value = ContainerTarget.CLASS)
public class ContainerNotNull {

	
	@Processors(NotNull.class)
	List<AnnotationPropertyValidator> lista;

	public List<AnnotationPropertyValidator> getLista() {
		return lista;
	}

	public void setLista(List<AnnotationPropertyValidator> lista) {
		this.lista = lista;
	}
	
	
}