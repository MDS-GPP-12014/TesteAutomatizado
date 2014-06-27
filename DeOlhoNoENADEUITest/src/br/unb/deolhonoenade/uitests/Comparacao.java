package br.unb.deolhonoenade.uitests;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class Comparacao extends UiAutomatorTestCase{
	
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
		UiScrollable listaCursos = new UiScrollable(new UiSelector().className("android.widget.ListView"));
		UiObject curso = listaCursos.getChildByText(new UiSelector().className("android.widget.CheckedTextView"), "Direito");
		curso.click();
	}
	
	public void testComparacaoEstados() throws UiObjectNotFoundException{
		
		UiObject botaoComparacao = new UiObject(new UiSelector().text("Comparação"));
		botaoComparacao.clickAndWaitForNewWindow();
		UiObject botaoMediaEntreEstados = new UiObject(new UiSelector().text("Média entre estados"));
		botaoMediaEntreEstados.clickAndWaitForNewWindow();
		
		/*ESCOLHA O PRIMEIRO ESTADO - MG*/
		UiObject spinnerEstado1 = new UiObject(new UiSelector().resourceId("br.unb.deolhonoenade:id/Estado1"));
		spinnerEstado1.click();
		UiScrollable listaEstados1 = new UiScrollable(new UiSelector().className("android.widget.ListView"));
		UiObject estado1 = listaEstados1.getChildByText(new UiSelector().className("android.widget.CheckedTextView"), "MG");
		estado1.click();
		
		/*ESCOLHA O SEGUNDO ESTADO - DF*/
		UiObject spinnerEstado2 = new UiObject(new UiSelector().resourceId("br.unb.deolhonoenade:id/Estado2"));
		spinnerEstado2.click();
		UiScrollable listaEstados2 = new UiScrollable(new UiSelector().className("android.widget.ListView"));
		UiObject estado2 = listaEstados2.getChildByText(new UiSelector().className("android.widget.CheckedTextView"), "DF");
		estado2.click();
		
		/*ESCOLHE O BOTAO COMPARAR*/
		UiObject botaoComparar = new UiObject(new UiSelector().text("Comparar"));
		botaoComparar.clickAndWaitForNewWindow();
		sleep(3000);
		
		for(int i=0; i < 4; i++){
			getUiDevice().pressBack();
		}	
	}
	
	public void testComparacaoEntreCidades() throws UiObjectNotFoundException{
		UiObject botaoComparacao = new UiObject(new UiSelector().text("Comparação"));
		botaoComparacao.clickAndWaitForNewWindow();
		UiObject botaoMediaEntreEstados = new UiObject(new UiSelector().text("Média entre cidades"));
		botaoMediaEntreEstados.clickAndWaitForNewWindow();
		
		/*ESCOLHE O PRIMEIRO ESTADO - MG*/
		UiObject spinnerEstado1 = new UiObject(new UiSelector().resourceId("br.unb.deolhonoenade:id/spinnerEstado1"));
		spinnerEstado1.click();
		UiScrollable listaEstados1 = new UiScrollable(new UiSelector().className("android.widget.ListView"));
		UiObject estado1 = listaEstados1.getChildByText(new UiSelector().className("android.widget.CheckedTextView"), "MG");
		estado1.click();
		
		/*ESCOLHE A CIDADE DO PRIMEIRO ESTADO - CONTAGEM*/
		UiObject spinnerCidade1 = new UiObject(new UiSelector().resourceId("br.unb.deolhonoenade:id/spinnerCidade1"));
		spinnerCidade1.click();
		UiScrollable listaCidades1 = new UiScrollable(new UiSelector().className("android.widget.ListView"));
		UiObject cidade1 = listaCidades1.getChildByText(new UiSelector().className("android.widget.CheckedTextView"), "CONTAGEM");
		cidade1.click();
		
		/*ESCOLHE O SEGUNDO ESTADO - DF*/
		UiObject spinnerEstado2 = new UiObject(new UiSelector().resourceId("br.unb.deolhonoenade:id/spinnerEstado2"));
		spinnerEstado2.click();
		UiScrollable listaEstados2 = new UiScrollable(new UiSelector().className("android.widget.ListView"));
		UiObject estado2 = listaEstados2.getChildByText(new UiSelector().className("android.widget.CheckedTextView"), "DF");
		estado2.click();
		
		/*ESCOLHE A CIDADE DO SEGUNDO ESTADO - BRASILIA*/
		UiObject spinnerCidade2 = new UiObject(new UiSelector().resourceId("br.unb.deolhonoenade:id/spinnerCidade2"));
		spinnerCidade2.click();
		UiScrollable listaCidades2 = new UiScrollable(new UiSelector().className("android.widget.ListView"));
		UiObject cidade2 = listaCidades2.getChildByText(new UiSelector().className("android.widget.CheckedTextView"), "BRASILIA");
		cidade2.click();
		
		/*CLICA NO BOTAO COMPARAR*/
		UiObject botaoComparar = new UiObject(new UiSelector().text("Comparar"));
		botaoComparar.clickAndWaitForNewWindow();
		sleep(3000);
		
		for(int i=0; i < 4; i++){
			getUiDevice().pressBack();
		}	
	}
	
	public void testComparacaoEntreIES() throws UiObjectNotFoundException{
		UiObject botaoComparacao = new UiObject(new UiSelector().text("Comparação"));
		botaoComparacao.clickAndWaitForNewWindow();
		UiObject botaoMediaEntreEstados = new UiObject(new UiSelector().text("Entre Instituições de Ensino"));
		botaoMediaEntreEstados.clickAndWaitForNewWindow();
		
		/*SELECIONA O PRIMEIRO ESTADO - MG*/
		UiObject spinnerEstado1 = new UiObject(new UiSelector().resourceId("br.unb.deolhonoenade:id/estados"));
		spinnerEstado1.click();
		UiScrollable listaEstados1 = new UiScrollable(new UiSelector().className("android.widget.ListView"));
		UiObject estado1 = listaEstados1.getChildByText(new UiSelector().className("android.widget.CheckedTextView"), "MG");
		estado1.click();
		
		/*ESCOLHE A CIDADE DO PRIMEIRO ESTADO - ARAXA*/
		UiObject spinnerCidade1 = new UiObject(new UiSelector().resourceId("br.unb.deolhonoenade:id/cidades"));
		spinnerCidade1.click();
		UiScrollable listaCidades1 = new UiScrollable(new UiSelector().className("android.widget.ListView"));
		UiObject cidade1 = listaCidades1.getChildByText(new UiSelector().className("android.widget.CheckedTextView"), "ARAXA");
		cidade1.click();
		
		/*ESCOLHE A INSTITUICAO*/
		UiObject spinnerIES1 = new UiObject(new UiSelector().resourceId("br.unb.deolhonoenade:id/spinnerIES"));
		spinnerIES1.click();
		UiScrollable listaIES1 = new UiScrollable(new UiSelector().className("android.widget.ListView"));
		UiObject IES1 = listaIES1.getChildByText(new UiSelector().className("android.widget.CheckedTextView"), "CENTRO UNIVERSITARIO DO PLANALTO DE ARAXA");
		IES1.click();
		
		/*SELECIONAR PROXIMA IES*/
		UiObject botaoProximaIES = new UiObject(new UiSelector().text("Selecione a segunda IES"));
		botaoProximaIES.clickAndWaitForNewWindow();
		
		/*SELECIONA O SEGUNDO ESTADO - DF*/
		UiObject spinnerEstado2 = new UiObject(new UiSelector().resourceId("br.unb.deolhonoenade:id/estados"));
		spinnerEstado2.click();
		UiScrollable listaEstados2 = new UiScrollable(new UiSelector().className("android.widget.ListView"));
		UiObject estado2 = listaEstados2.getChildByText(new UiSelector().className("android.widget.CheckedTextView"), "DF");
		estado2.click();
		
		/*ESCOLHE A CIDADE DO SEGUNDO ESTADO - BRASILIA*/
		UiObject spinnerCidade2 = new UiObject(new UiSelector().resourceId("br.unb.deolhonoenade:id/cidades"));
		spinnerCidade2.click();
		UiScrollable listaCidades2 = new UiScrollable(new UiSelector().className("android.widget.ListView"));
		UiObject cidade2 = listaCidades2.getChildByText(new UiSelector().className("android.widget.CheckedTextView"), "BRASILIA");
		cidade2.click();
		
		/*ESCOLHE A INSTITUICAO*/
		UiObject spinnerIES2 = new UiObject(new UiSelector().resourceId("br.unb.deolhonoenade:id/spinnerIES"));
		spinnerIES2.click();
		UiScrollable listaIES2 = new UiScrollable(new UiSelector().className("android.widget.ListView"));
		UiObject IES2 = listaIES2.getChildByText(new UiSelector().className("android.widget.CheckedTextView"), "CENTRO UNIVERSITARIO DE BRASILIA");
		IES2.click();
		
		/*CLICA NO BOTAO COMPARAR*/
		UiObject botaoComparar = new UiObject(new UiSelector().text("Comparar"));
		botaoComparar.clickAndWaitForNewWindow();
		sleep(3000);
		
		for(int i=0; i < 5; i++){
			getUiDevice().pressBack();
		}
	}
	
	public void testComparacaoEntreTipos() throws UiObjectNotFoundException{
		UiObject botaoComparacao = new UiObject(new UiSelector().text("Comparação"));
		botaoComparacao.clickAndWaitForNewWindow();
		UiObject botaoMediaEntreEstados = new UiObject(new UiSelector().text("Entre Tipos de Instituições de Ensino"));
		botaoMediaEntreEstados.clickAndWaitForNewWindow();
		
		
		/*SELECIONA O PRIMEIRO ESTADO - GO*/
		UiObject spinnerEstado1 = new UiObject(new UiSelector().resourceId("br.unb.deolhonoenade:id/SpinnerEstado1"));
		spinnerEstado1.click();
		UiScrollable listaEstados1 = new UiScrollable(new UiSelector().className("android.widget.ListView"));
		UiObject estado1 = listaEstados1.getChildByText(new UiSelector().className("android.widget.CheckedTextView"), "GO");
		estado1.click();
		
		/*ESCOLHE O TIPO DO PRIMEIRO ESTADO - PRIVADO*/
		UiObject spinnerTipo1 = new UiObject(new UiSelector().resourceId("br.unb.deolhonoenade:id/SpinnerEstado1Tipo"));
		spinnerTipo1.click();
		UiObject tipo1 = new UiObject(new UiSelector().text("PUBLICA"));
		tipo1.click();
		
		/*SELECIONA O SEGUNDO ESTADO - GO*/
		UiObject spinnerEstado2 = new UiObject(new UiSelector().resourceId("br.unb.deolhonoenade:id/SpinnerEstado2"));
		spinnerEstado2.click();
		UiScrollable listaEstados2 = new UiScrollable(new UiSelector().className("android.widget.ListView"));
		UiObject estado2 = listaEstados2.getChildByText(new UiSelector().className("android.widget.CheckedTextView"), "GO");
		estado2.click();
		
		/*ESCOLHE O TIPO DO PRIMEIRO ESTADO - PRIVADO*/
		UiObject spinnerTipo2 = new UiObject(new UiSelector().resourceId("br.unb.deolhonoenade:id/SpinnerEstado2Tipo"));
		spinnerTipo2.click();
		UiObject tipo2 = new UiObject(new UiSelector().text("PUBLICA"));
		tipo2.click();
		
		/*CLICAR EM BUSCAR*/
		UiObject botaoComparar = new UiObject(new UiSelector().text("BUSCAR"));
		botaoComparar.clickAndWaitForNewWindow();
		sleep(3000);
		
		for(int i=0; i < 4; i++){
			getUiDevice().pressBack();
		}
	}
	
	public void tearDown() throws UiObjectNotFoundException, RemoteException{
		UiDevice celular = getUiDevice();
		celular.pressBack();
		celular.pressHome();
		celular.sleep();
	}
}
