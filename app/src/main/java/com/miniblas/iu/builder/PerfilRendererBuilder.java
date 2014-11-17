package com.miniblas.iu.builder;

import java.util.Collection;

import javax.inject.Inject;

import com.miniblas.iu.renderers.PerfilRenderer;
import com.miniblas.model.MiniBlasPerfil;

import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;

public class PerfilRendererBuilder extends RendererBuilder<MiniBlasPerfil>{
	
	
	@Inject
	public PerfilRendererBuilder(Collection<Renderer<MiniBlasPerfil>> prototypes) {
		super(prototypes);
	}

	@Override
	protected Class getPrototypeClass(MiniBlasPerfil perfil) {
		 Class prototypeClass;
	        
	            prototypeClass = PerfilRenderer.class;
	        
	        return prototypeClass;
	}
}
