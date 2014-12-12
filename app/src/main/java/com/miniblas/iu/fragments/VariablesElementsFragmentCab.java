package com.miniblas.iu.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.miniblas.app.AplicacionPrincipal;
import com.miniblas.app.R;
import com.miniblas.iu.AcercaDe;
import com.miniblas.iu.FabActivity;
import com.miniblas.iu.Preferences;
import com.miniblas.iu.controllers.VariablesController;
import com.miniblas.iu.controllers.base.BaseController;
import com.miniblas.iu.fragments.base.CabOrdenableElementsFragment;
import com.miniblas.iu.utils.SeleccionableRendererAdapter;
import com.miniblas.model.MiniBlasItemVariable;
import com.miniblas.perfistence.ormlite.Constantes;

import javax.inject.Inject;

/**
 * Created by alberto on 13/11/14.
 */
public class VariablesElementsFragmentCab extends CabOrdenableElementsFragment<MiniBlasItemVariable>{
	@Inject
	public SeleccionableRendererAdapter<MiniBlasItemVariable> adaptador;

	private VariablesController controller;
	private Menu menu;
	private android.view.ActionMode mode;
	private MenuItem iconoEstado;
	public static final int RESULT_OK = 1;
	public static final int REQUEST_CODE = 1234;


	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		AplicacionPrincipal application = (AplicacionPrincipal) getActivity().getApplication();
		application.inject(this);
		setAdapter(adaptador);
		setListAdapter(getAdapter());
		//getListView().setOnItemClickListener(new OnPerfilClickedListener());
		//PerfilCab pc = new PerfilCab();
		//pc.setContext(getActivity());
		//((FabActivity) getActivity()).setCab(pc);
		//pc.setFragment(this);
		controller = VariablesController.getInstance(application);
	}


	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		setHasOptionsMenu(true);
		getListView().setChoiceMode(ListView.CHOICE_MODE_NONE);
		FabActivity act = (FabActivity) getActivity();
		act.setTitle(getResources().getString(R.string.listaVariables));
		//act.disableFab(true);
		Bundle extras = getArguments();
		int id_basket = extras.getInt(Constantes.BASKET_TABLE_NAME);
		int id_profile = extras.getInt(Constantes.PROFILE_TABLE_NAME);
		System.out.println("Id del perfil en variables: " + id_profile);
		System.out.println("Nombre cesta en variables: " + id_basket);
		controller.onViewChange(this, id_profile, id_basket);
		(((ActionBarActivity) getActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
		act.setFabListener(new FabActivity.FabListener(){
			@Override
			public void onFabPressed(){
				gotoNewVariableFragment();
			}
		});
	}

	public void gotoNewVariableFragment(){
		Bundle data = new Bundle();
		data.putInt(Constantes.PROFILE_TABLE_NAME, controller.getIdProfile());
		data.putInt(Constantes.BASKET_TABLE_NAME, controller.getBasket().getId());
		//getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
		getFragmentManager().executePendingTransactions();
		FragmentTransaction trans = getFragmentManager().beginTransaction();
		trans.setCustomAnimations(R.anim.left_in, R.anim.left_out, R.anim.right_in, R.anim.right_out);
		NewVariableElementsFragmentCab fragment = new NewVariableElementsFragmentCab();
		fragment.setArguments(data);
		//setTargetFragment(fragment, REQUEST_CODE);
		trans.replace(R.id.container, fragment);
		trans.addToBackStack(null);
		trans.commit();
	}

	@Override
	public void onStop(){
		super.onStop();
		controller.saveElements();

	}

	@Override
	public void loadState(){

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data){
		if(requestCode == REQUEST_CODE){
			if(resultCode == RESULT_OK){
				Toast.makeText(getActivity(), getResources().getString(R.string.variablesAñadidas), Toast.LENGTH_SHORT).show();
				controller.onViewChange(this);
			}else{
				Toast.makeText(getActivity(), getResources().getString(R.string.noAñadidaVariable), Toast.LENGTH_SHORT).show();
			}
		}
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
		super.onCreateOptionsMenu(menu, inflater);
		getActivity().getMenuInflater().inflate(R.menu.menu_variables, menu);
		iconoEstado = (MenuItem) menu.findItem(R.id.estado);
		((AplicacionPrincipal) getActivity().getApplication()).setIconObserver(controller);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch(item.getItemId()){
			case android.R.id.home:
				((FabActivity) getActivity()).backStackFragment();
				return (true);
			case R.id.menu_anadir_variable:
				gotoNewVariableFragment();
				return true;
			case R.id.Acercade:
				Intent i = new Intent(getActivity(), AcercaDe.class);
				startActivity(i);
				return true;
			case R.id.menu_ajustes:
				Intent intent = new Intent(getActivity(), Preferences.class);
				startActivity(intent);
				return true;
		}

		return super.onOptionsItemSelected(item);
	}


	@Override
	public void setConnectIcon(){
		runOnUiThread(new Runnable(){
			@Override
			public void run(){
				System.out.println("Poniendo el semaforo de variables en verde");
				if(iconoEstado != null){
					System.out.println("Poniendolo........");
					iconoEstado.setIcon(R.drawable.conectado);
				}
			}
		});
	}

	@Override
	public void setDisconnectIcon(){
		runOnUiThread(new Runnable(){
			@Override
			public void run(){
				if(iconoEstado != null){
					iconoEstado.setIcon(R.drawable.desconectado);
				}
			}
		});
	}


	@Override
	public void msgErrorSavingElementsToBD(){
		runOnUiThread(new Runnable(){
			@Override
			public void run(){
				Toast.makeText(getActivity(), getResources().getString(R.string.errorAccessBd), Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public void msgErrorGettingElementsInBD(){
		runOnUiThread(new Runnable(){
			@Override
			public void run(){
				Toast.makeText(getActivity(), getResources().getString(R.string.errorAccessBd), Toast.LENGTH_SHORT).show();
			}
		});
	}


	@Override
	public void msgButtonNewSave(){

	}

	@Override
	public void msgButtonNewCancel(){
	}

	@Override
	public void msgButtonEditSave(){
	}

	@Override
	public void msgButtonEditCancel(){
	}

	@Override
	public void msgErrorDeleteElementsInBD(){
	}


	public void runOnUiThread(Runnable runnable){
		if(getActivity() != null){
			getActivity().runOnUiThread(runnable);
		}
	}

	public BaseController<MiniBlasItemVariable> getController(){
		return controller;
	}


}
