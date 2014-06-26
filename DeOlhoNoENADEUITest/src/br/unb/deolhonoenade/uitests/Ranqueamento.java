package br.unb.deolhonoenade.uitests;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class Ranqueamento extends UiAutomatorTestCase{
	
	public void setUp() throws UiObjectNotFoundException, RemoteException{
		/*LIGA O CELULAR E PROCURA PELO APLICATIVO*/
		UiDevice celular = getUiDevice();
		if(!celular.isScreenOn()){
			celular.wakeUp();
			celular.drag(539, 1345, 1067, 1356, 40);
		}
		celular.pressHome();
		UiObject botaoTodosApps = new UiObject(new UiSelector().description("Aplicativos"));
		botaoTodosApps.clickAndWaitForNewWindow();
		
		UiObject appsTab = new UiObject(new UiSelector().text("Aplicativos"));
		appsTab.click();
		
		UiScrollable todosApps = new UiScrollable(new UiSelector().scrollable(true));
		todosApps.setAsHorizontalList();
		UiObject deOlhoNoEnade = todosApps.getChildByText(new UiSelector().className("android.widget.TextView"), "DeOlhoNoENADE");
		deOlhoNoEnade.clickAndWaitForNewWindow();
		
		/*INICIALIZA O APP*/
		UiObject imagemLogo = new UiObject(new UiSelector().className("android.widget.ImageView"));
		imagemLogo.clickAndWaitForNewWindow();
		
		/*AQUI O CURSO É SELECIONADO - DIREITO*/
		UiObject spinnerCurso = new UiObject(new UiSelector().resourceId("br.unb.deolhonoenade:id/spinnerCurso"));
		spinnerCurso.click();
		UiScrollable listaCursos = new UiScrollable(new UiSelector().scrollable(true));
		UiObject curso = listaCursos.getChildByText(new UiSelector().className("android.widget.CheckedTextView"), "Direito");
		curso.click();
	}
	
	public void testRanqueamento() throws UiObjectNotFoundException{
		/*ESCOLHE A OPCAO DE RANKING*/
		UiObject botaoRanking = new UiObject(new UiSelector().text("Ranking"));
		botaoRanking.clickAndWaitForNewWindow();
		
		/*ESCOLHE O ESTADO - SP*/
		UiObject spinnerEstado = new UiObject(new UiSelector().resourceId("br.unb.deolhonoenade:id/SpinnerEstados"));
		spinnerEstado.click();
		UiScrollable listaEstados = new UiScrollable(new UiSelector().scrollable(true));
		UiObject estado = listaEstados.getChildByText(new UiSelector().className("android.widget.CheckedTextView"), "SP");
		estado.click();
		
		/*ESCOLHE A CIDADE - Campinas*/
		UiObject spinnerCidade = new UiObject(new UiSelector().resourceId("br.unb.deolhonoenade:id/spinnerCidade"));
		spinnerCidade.click();
		UiScrollable listaCidades = new UiScrollable(new UiSelector().scrollable(true));
		UiObject cidade = listaCidades.getChildByText(new UiSelector().className("android.widget.CheckedTextView"), "CAMPINAS");
		cidade.click();
		
		/*ESCOLHE O TIPO - privado*/
		UiObject spinnerTipoObject = new UiObject(new UiSelector().resourceId("br.unb.deolhonoenade:id/spinnerTipo"));
		spinnerTipoObject.click();
		UiObject tipo = new UiObject(new UiSelector().text("PRIVADA"));
		tipo.click();
		
		/*CLICA EM BUSCAR*/
		UiObject botaoBuscar = new UiObject(new UiSelector().text("BUSCAR"));
		botaoBuscar.clickAndWaitForNewWindow();
		
	}
	
	public void tearDown() throws UiObjectNotFoundException{
		for(int i = 0; i < 3; i++){
			getUiDevice().pressBack();
		}
		getUiDevice().pressHome();
	}

}
