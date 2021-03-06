/*
 * File:           ConfiguracionScanner.java
 * Generated from: configuracion.dtd
 * Date:           13 de febrero de 2007  17:21
 *
 * @author  fserna
 * @version generated by NetBeans XML module
 */
/**
 *
 * This is a scanner of DOM tree.
 *
 * Example:
 * <pre>
 *     javax.xml.parsers.DocumentBuilderFactory builderFactory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
 *     javax.xml.parsers.DocumentBuilder builder = builderFactory.newDocumentBuilder();
 *     org.w3c.dom.Document document = builder.parse (new org.xml.sax.InputSource (???));
 *     <font color="blue">ConfiguracionScanner scanner = new ConfiguracionScanner (document);</font>
 *     <font color="blue">scanner.visitDocument();</font>
 * </pre>
 *
 * @see org.w3c.dom.Document
 * @see org.w3c.dom.Element
 * @see org.w3c.dom.NamedNodeMap
 */

package com.arcadio.xml;

public class ConfiguracionScanner{
	/**
	 * org.w3c.dom.Document document
	 */
	org.w3c.dom.Document document;
	private Configuracion configuracion;
	private Instancia instancia;
	private Propiedad propiedad;

	/**
	 * Create new ConfiguracionScanner with org.w3c.dom.Document.
	 */
	public ConfiguracionScanner(org.w3c.dom.Document document, Configuracion _configuracion){
		this.document = document;
		this.configuracion = _configuracion;
	}

	/**
	 * Scan through org.w3c.dom.Document document.
	 */
	public void visitDocument(){
		org.w3c.dom.Element element = document.getDocumentElement();
		if((element != null) && element.getTagName().equals("emcos")){
			visitElement_emcos(element);


			if(instancia != null){
				configuracion.addInstancia(instancia);
				instancia = null;
			}
			if(propiedad != null){
				configuracion.addPropiedad(propiedad);
				propiedad = null;
			}

		}
		if((element != null) && element.getTagName().equals("instancias")){
			visitElement_instancias(element);
		}
		if((element != null) && element.getTagName().equals("instancia")){
			visitElement_instancia(element);
		}
		if((element != null) && element.getTagName().equals("nombreInstancia")){
			visitElement_nombreInstancia(element);
		}
		if((element != null) && element.getTagName().equals("clase")){
			visitElement_clase(element);
		}
		if((element != null) && element.getTagName().equals("orden")){
			visitElement_orden(element);
		}
		if((element != null) && element.getTagName().equals("habilitado")){
			visitElement_habilitado(element);
		}
		if((element != null) && element.getTagName().equals("propiedades")){
			visitElement_propiedades(element);
		}
		if((element != null) && element.getTagName().equals("propiedad")){
			visitElement_propiedad(element);
		}
		if((element != null) && element.getTagName().equals("nombrePropiedad")){
			visitElement_nombrePropiedad(element);
		}
		if((element != null) && element.getTagName().equals("valor")){
			visitElement_valor(element);
		}
	}

	/**
	 * Scan through org.w3c.dom.Element named emcos.
	 */
	void visitElement_emcos(org.w3c.dom.Element element){ // <emcos>
		// element.getValue();
		org.w3c.dom.NodeList nodes = element.getChildNodes();
		for(int i = 0; i < nodes.getLength(); i++){
			org.w3c.dom.Node node = nodes.item(i);
			switch(node.getNodeType()){
				case org.w3c.dom.Node.CDATA_SECTION_NODE:
					// ((org.w3c.dom.CDATASection)node).getData();
					break;
				case org.w3c.dom.Node.ELEMENT_NODE:
					org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
					if(nodeElement.getTagName().equals("instancias")){
						visitElement_instancias(nodeElement);
					}
					if(nodeElement.getTagName().equals("propiedades")){
						visitElement_propiedades(nodeElement);
					}
					break;
				case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
					// ((org.w3c.dom.ProcessingInstruction)node).getTarget();
					// ((org.w3c.dom.ProcessingInstruction)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through org.w3c.dom.Element named instancias.
	 */
	void visitElement_instancias(org.w3c.dom.Element element){ // <instancias>
		// element.getValue();

		org.w3c.dom.NodeList nodes = element.getChildNodes();
		for(int i = 0; i < nodes.getLength(); i++){
			org.w3c.dom.Node node = nodes.item(i);
			switch(node.getNodeType()){
				case org.w3c.dom.Node.CDATA_SECTION_NODE:
					// ((org.w3c.dom.CDATASection)node).getData();
					break;
				case org.w3c.dom.Node.ELEMENT_NODE:
					org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
					if(nodeElement.getTagName().equals("instancia")){
						visitElement_instancia(nodeElement);
					}
					break;
				case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
					// ((org.w3c.dom.ProcessingInstruction)node).getTarget();
					// ((org.w3c.dom.ProcessingInstruction)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through org.w3c.dom.Element named instancia.
	 */
	void visitElement_instancia(org.w3c.dom.Element element){ // <instancia>
		// element.getValue();
		org.w3c.dom.NodeList nodes = element.getChildNodes();
		if(instancia != null){
			configuracion.addInstancia(instancia);
			instancia = null;
		}
		instancia = new Instancia();


		for(int i = 0; i < nodes.getLength(); i++){
			org.w3c.dom.Node node = nodes.item(i);
			switch(node.getNodeType()){
				case org.w3c.dom.Node.CDATA_SECTION_NODE:
					// ((org.w3c.dom.CDATASection)node).getData();
					break;
				case org.w3c.dom.Node.ELEMENT_NODE:
					org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
					if(nodeElement.getTagName().equals("nombreInstancia")){
						visitElement_nombreInstancia(nodeElement);
					}
					if(nodeElement.getTagName().equals("clase")){
						visitElement_clase(nodeElement);
					}
					if(nodeElement.getTagName().equals("orden")){
						visitElement_orden(nodeElement);
					}
					if(nodeElement.getTagName().equals("habilitado")){
						visitElement_habilitado(nodeElement);
					}
					break;
				case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
					// ((org.w3c.dom.ProcessingInstruction)node).getTarget();
					// ((org.w3c.dom.ProcessingInstruction)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through org.w3c.dom.Element named nombreInstancia.
	 */
	void visitElement_nombreInstancia(org.w3c.dom.Element element){ // <nombreInstancia>
		// element.getValue();
		org.w3c.dom.NodeList nodes = element.getChildNodes();
		for(int i = 0; i < nodes.getLength(); i++){
			org.w3c.dom.Node node = nodes.item(i);
			switch(node.getNodeType()){
				case org.w3c.dom.Node.CDATA_SECTION_NODE:
					// ((org.w3c.dom.CDATASection)node).getData();
					break;
				case org.w3c.dom.Node.ELEMENT_NODE:
					org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
					break;
				case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
					// ((org.w3c.dom.ProcessingInstruction)node).getTarget();
					// ((org.w3c.dom.ProcessingInstruction)node).getData();
					break;
				case org.w3c.dom.Node.TEXT_NODE:
					// ((org.w3c.dom.Text)node).getData();
					instancia.setNombreInstancia(((org.w3c.dom.Text) node).getData());
					break;
			}
		}
	}

	/**
	 * Scan through org.w3c.dom.Element named clase.
	 */
	void visitElement_clase(org.w3c.dom.Element element){ // <clase>
		// element.getValue();
		org.w3c.dom.NodeList nodes = element.getChildNodes();
		for(int i = 0; i < nodes.getLength(); i++){
			org.w3c.dom.Node node = nodes.item(i);
			switch(node.getNodeType()){
				case org.w3c.dom.Node.CDATA_SECTION_NODE:
					// ((org.w3c.dom.CDATASection)node).getData();
					break;
				case org.w3c.dom.Node.ELEMENT_NODE:
					org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
					break;
				case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
					// ((org.w3c.dom.ProcessingInstruction)node).getTarget();
					// ((org.w3c.dom.ProcessingInstruction)node).getData();
					break;
				case org.w3c.dom.Node.TEXT_NODE:
					// ((org.w3c.dom.Text)node).getData();
					instancia.setClase(((org.w3c.dom.Text) node).getData());
					break;
			}
		}
	}

	/**
	 * Scan through org.w3c.dom.Element named orden.
	 */
	void visitElement_orden(org.w3c.dom.Element element){ // <orden>
		// element.getValue();
		org.w3c.dom.NodeList nodes = element.getChildNodes();
		for(int i = 0; i < nodes.getLength(); i++){
			org.w3c.dom.Node node = nodes.item(i);
			switch(node.getNodeType()){
				case org.w3c.dom.Node.CDATA_SECTION_NODE:
					// ((org.w3c.dom.CDATASection)node).getData();
					break;
				case org.w3c.dom.Node.ELEMENT_NODE:
					org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
					break;
				case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
					// ((org.w3c.dom.ProcessingInstruction)node).getTarget();
					// ((org.w3c.dom.ProcessingInstruction)node).getData();
					break;
				case org.w3c.dom.Node.TEXT_NODE:
					// ((org.w3c.dom.Text)node).getData();
					int orden = Integer.valueOf((((org.w3c.dom.Text) node).getData())).intValue();
					instancia.setOrden(orden);
					break;
			}
		}
	}

	/**
	 * Scan through org.w3c.dom.Element named habilitado.
	 */
	void visitElement_habilitado(org.w3c.dom.Element element){ // <habilitado>
		// element.getValue();
		org.w3c.dom.NodeList nodes = element.getChildNodes();
		for(int i = 0; i < nodes.getLength(); i++){
			org.w3c.dom.Node node = nodes.item(i);
			switch(node.getNodeType()){
				case org.w3c.dom.Node.CDATA_SECTION_NODE:
					// ((org.w3c.dom.CDATASection)node).getData();
					break;
				case org.w3c.dom.Node.ELEMENT_NODE:
					org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
					break;
				case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
					// ((org.w3c.dom.ProcessingInstruction)node).getTarget();
					// ((org.w3c.dom.ProcessingInstruction)node).getData();
					break;
				case org.w3c.dom.Node.TEXT_NODE:
					// ((org.w3c.dom.Text)node).getData();
					String txtHabilitado = ((org.w3c.dom.Text) node).getData();
					if(txtHabilitado.equals("true")){
						instancia.setHabilitado(true);
					}else{
						instancia.setHabilitado(false);
					}
					break;
			}
		}
	}

	/**
	 * Scan through org.w3c.dom.Element named propiedades.
	 */
	void visitElement_propiedades(org.w3c.dom.Element element){ // <propiedades>
		// element.getValue();

		if(instancia != null){
			configuracion.addInstancia(instancia);
			instancia = null;
		}

		org.w3c.dom.NodeList nodes = element.getChildNodes();
		for(int i = 0; i < nodes.getLength(); i++){
			org.w3c.dom.Node node = nodes.item(i);
			switch(node.getNodeType()){
				case org.w3c.dom.Node.CDATA_SECTION_NODE:
					// ((org.w3c.dom.CDATASection)node).getData();
					break;
				case org.w3c.dom.Node.ELEMENT_NODE:
					org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
					if(nodeElement.getTagName().equals("propiedad")){
						visitElement_propiedad(nodeElement);
					}
					break;
				case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
					// ((org.w3c.dom.ProcessingInstruction)node).getTarget();
					// ((org.w3c.dom.ProcessingInstruction)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through org.w3c.dom.Element named propiedad.
	 */
	void visitElement_propiedad(org.w3c.dom.Element element){ // <propiedad>
		// element.getValue();
		if(propiedad != null){
			configuracion.addPropiedad(propiedad);
			propiedad = null;
		}
		propiedad = new Propiedad();

		org.w3c.dom.NodeList nodes = element.getChildNodes();
		for(int i = 0; i < nodes.getLength(); i++){
			org.w3c.dom.Node node = nodes.item(i);
			switch(node.getNodeType()){
				case org.w3c.dom.Node.CDATA_SECTION_NODE:
					// ((org.w3c.dom.CDATASection)node).getData();
					break;
				case org.w3c.dom.Node.ELEMENT_NODE:
					org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
					if(nodeElement.getTagName().equals("nombrePropiedad")){
						visitElement_nombrePropiedad(nodeElement);
					}
					if(nodeElement.getTagName().equals("valor")){
						visitElement_valor(nodeElement);
					}
					break;
				case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
					// ((org.w3c.dom.ProcessingInstruction)node).getTarget();
					// ((org.w3c.dom.ProcessingInstruction)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through org.w3c.dom.Element named nombrePropiedad.
	 */
	void visitElement_nombrePropiedad(org.w3c.dom.Element element){ // <nombrePropiedad>
		// element.getValue();
		org.w3c.dom.NodeList nodes = element.getChildNodes();
		for(int i = 0; i < nodes.getLength(); i++){
			org.w3c.dom.Node node = nodes.item(i);
			switch(node.getNodeType()){
				case org.w3c.dom.Node.CDATA_SECTION_NODE:
					// ((org.w3c.dom.CDATASection)node).getData();
					break;
				case org.w3c.dom.Node.ELEMENT_NODE:
					org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
					break;
				case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
					// ((org.w3c.dom.ProcessingInstruction)node).getTarget();
					// ((org.w3c.dom.ProcessingInstruction)node).getData();
					break;
				case org.w3c.dom.Node.TEXT_NODE:
					// ((org.w3c.dom.Text)node).getData();
					propiedad.setNombrePropiedad(((org.w3c.dom.Text) node).getData());
					break;
			}
		}
	}

	/**
	 * Scan through org.w3c.dom.Element named valor.
	 */
	void visitElement_valor(org.w3c.dom.Element element){ // <valor>
		// element.getValue();
		org.w3c.dom.NodeList nodes = element.getChildNodes();
		for(int i = 0; i < nodes.getLength(); i++){
			org.w3c.dom.Node node = nodes.item(i);
			switch(node.getNodeType()){
				case org.w3c.dom.Node.CDATA_SECTION_NODE:
					// ((org.w3c.dom.CDATASection)node).getData();
					break;
				case org.w3c.dom.Node.ELEMENT_NODE:
					org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
					break;
				case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
					// ((org.w3c.dom.ProcessingInstruction)node).getTarget();
					// ((org.w3c.dom.ProcessingInstruction)node).getData();
					break;
				case org.w3c.dom.Node.TEXT_NODE:
					// ((org.w3c.dom.Text)node).getData();
					propiedad.setValor(((org.w3c.dom.Text) node).getData());
					break;
			}
		}
	}


}
