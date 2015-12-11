package es.iesnervion.android.ignacio.pruebacontroles;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ControlesActividad extends Activity implements android.widget.RadioGroup.OnCheckedChangeListener {

	RadioGroup radios1;
	EditText num1, num2;
	TextView resultado;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_controles_actividad);
		num1 = (EditText) findViewById(R.id.num1);
		num2 = (EditText) findViewById(R.id.num2);
		resultado = (TextView) findViewById(R.id.resultado);
		radios1 = (RadioGroup) findViewById(R.id.radioLista);
		radios1.setOnCheckedChangeListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.controles_actividad, menu);
		return true;
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		
		int intNum1 = 0, intNum2 = 0;
		
		try{
			intNum1 = Integer.parseInt(num1.getText().toString());	
			intNum2 = Integer.parseInt(num2.getText().toString());	
		}
		catch(NumberFormatException ex){
        	System.out.println("No puede haber campos vacíos");	
		}
		
		int suma = intNum1 + intNum2;
		int resta = intNum1 - intNum2;
		int mult = intNum1 * intNum2;
		
		
		switch (checkedId) {
		case R.id.radio1:
			resultado.setText((CharSequence)Integer.toString(suma));
			Toast.makeText(this, "La suma es: "+suma, Toast.LENGTH_LONG).show();	
		break;
		case R.id.radio2:
			resultado.setText(Integer.toString(resta));
			Toast toast2 = Toast.makeText(getApplicationContext(), Integer.toString(resta), Toast.LENGTH_SHORT);	
			toast2.setGravity(Gravity.CENTER | Gravity.LEFT,0,0);
			toast2.show();	
			//toast2.makeText(this, "La resta es: "+resta, Toast.LENGTH_LONG).show();	
		break;
		case R.id.radio3:
			resultado.setText(Integer.toString(mult));
			Toast toast3 = new Toast(getApplicationContext());
			
			LayoutInflater inflater = getLayoutInflater();
			View layout = inflater.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.vistaToast));

			TextView txtMsg = (TextView)layout.findViewById(R.id.txtMensaje);
			txtMsg.setText(Integer.toString(mult));
			toast3.setGravity(Gravity.CENTER ,0,0);
			toast3.setDuration(Toast.LENGTH_SHORT);
			toast3.setView(layout);
			toast3.show();	
		break;
		
		}
	}
	
}
