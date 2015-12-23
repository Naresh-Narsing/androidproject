package com.example.bridge.sqllite;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    dataconnect mydb;
    EditText editName,editSurname,editMarks,editid;
    Button btnAdd;
    Button btnView;
    Button btnUpdt;
    Button btnDel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         mydb=new dataconnect(this);

        editid=(EditText)findViewById(R.id.editTextid);
        editName=(EditText)findViewById(R.id.name);
        editSurname=(EditText)findViewById(R.id.edittext_surname);
        editMarks=(EditText)findViewById(R.id.edittext_marks);
        btnAdd=(Button)findViewById(R.id.button_add);
        Add();

        btnView=(Button)findViewById(R.id.Showdata);
        viewAll();

        btnUpdt=(Button)findViewById(R.id.update);
        updateData();

        btnDel=(Button)findViewById(R.id.delete);
        Deletedata();
    }

    public void Add(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isInserted= mydb.insertdata(editName.getText().toString(),
                        editSurname.getText().toString(),
                        editMarks.getText().toString());

                if(isInserted == true)
                    Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Data Not Inserted",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void viewAll()
    {
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res =mydb.getAllData();

                if(res.getCount()==0){
                    Showmessage("Error","Nothing Found");
                    return;
                }
                else{
                    StringBuffer stringBuffer=new StringBuffer();
                    while (res.moveToNext()){
                        stringBuffer.append("ID :"+ res.getString(0)+"\n");
                        stringBuffer.append("Name :"+ res.getString(1)+"\n");
                        stringBuffer.append("Surname :"+ res.getString(2)+"\n");
                        stringBuffer.append("Marks :"+ res.getString(3)+"\n");
                    }
                    Showmessage("Data",stringBuffer.toString());
                }
            }
        });
    }

    public void Showmessage(String title,String message){

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


    public void updateData()
    {
        btnUpdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate = mydb.updatedata(editid.getText().toString(), editName.getText().toString(),
                        editSurname.getText().toString(), editMarks.getText().toString());


                if (isUpdate == true)
                    Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Data Not Updated", Toast.LENGTH_LONG).show();

            }
        });
    }


    public void Deletedata()
    {
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer DeletedRows = mydb.deletedata(editid.getText().toString());

                if(DeletedRows > 0)

                    Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
                    else
                    Toast.makeText(MainActivity.this, "Data Not Deleted", Toast.LENGTH_LONG).show();

            }
        });
    }





















    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
