package com.miniblas.iu.renderers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.arcadio.api.v1.service.exceptions.NoConnectedArcadioException;
import com.arcadio.api.v1.service.exceptions.ServiceDisconnectedArcadioException;
import com.kyleduo.switchbutton.switchbutton.SwitchButton;
import com.miniblas.app.AplicacionPrincipal;
import com.miniblas.app.R;
import com.miniblas.iu.FabActivity;
import com.miniblas.model.variableWidgets.VariableSwitchWidget;
import com.miniblas.model.variableWidgets.base.BaseVariableWidget;
import com.pedrogomez.renderers.Renderer;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SwitchVariableRenderer extends Renderer<BaseVariableWidget>{


	/*
	 * Attributes
	 */
	private final Context context;
	private final AplicacionPrincipal app;

	/*
	 * Constructor
     */

	public SwitchVariableRenderer(Context context){
		this.context = context;
		app = (AplicacionPrincipal) context.getApplicationContext();
	}
    /*
     * Widgets
     */

	@InjectView(R.id.tv_nom_variable)
	TextView tv_nom_variable;
	//    @InjectView(R.id.ch_marcar_perfil)
	//    CheckBox ch_marcar_perfil;
	@InjectView(R.id.switch1)
	SwitchButton switch1;


	@Override
	protected void setUpView(View rootView){
		// TODO Auto-generated method stub

	}

	@Override
	protected void hookListeners(View rootView){
		// TODO Auto-generated method stub

	}

	@Override
	protected View inflate(LayoutInflater inflater, ViewGroup parent){
		View inflatedView = inflater.inflate(R.layout.lyt_lista_variable_switch, parent, false);
		ButterKnife.inject(this, inflatedView);
		return inflatedView;
	}

	@Override
	public void render(){
		final VariableSwitchWidget variable = (VariableSwitchWidget) getContent();
		tv_nom_variable.setText(variable.getWidgetName());
		switch1.setChecked(variable.getValue().equals(variable.getValue_on()));
		switch1.setChecked((variable.getValue().equals(variable.getValue_on())) == true);
		switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
				if(isChecked){
					variable.setValue(variable.getValue_on());
				}else{
					variable.setValue(variable.getValue_off());
				}
				try{
					app.getArcadioService().writeVariable(variable.getNameElement(), variable.getValue());
				}catch(ServiceDisconnectedArcadioException e){
					((FabActivity)context).addLineTerminal(context.getString(R.string.servicioDesconectado));
				}catch(NoConnectedArcadioException e){
					((FabActivity)context).addLineTerminal(context.getString(
							R.string.imposibleEscribirVariable)+" "+variable.getNameElement());
					((FabActivity)context).addLineTerminal(e.toString());
				}
			}
		});
		switch1.setFocusable(false);
	}

}
